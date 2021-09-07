package isi.dan.laboratorios.danmsusuarios.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import isi.dan.laboratorios.danmsusuarios.domain.Obra;
import isi.dan.laboratorios.danmsusuarios.domain.Usuario;
import isi.dan.laboratorios.danmsusuarios.dtos.requests.ClienteRequestDTO;
import isi.dan.laboratorios.danmsusuarios.dtos.requests.ObraRequestDTO;
import isi.dan.laboratorios.danmsusuarios.exceptions.BadRequestException;
import isi.dan.laboratorios.danmsusuarios.exceptions.DataNotFoundException;
import isi.dan.laboratorios.danmsusuarios.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import isi.dan.laboratorios.danmsusuarios.domain.Cliente;
import isi.dan.laboratorios.danmsusuarios.dtos.ClienteDTO;
import isi.dan.laboratorios.danmsusuarios.repositories.ClienteRepository;
import isi.dan.laboratorios.danmsusuarios.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    RiesgoBCRAImpl riesgoService;

    @Autowired
    ClienteRepository clienteRepo;

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Autowired
    ObraServiceImpl obraService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public ClienteDTO guardarCliente(ClienteRequestDTO clienteDTO) {

        Cliente cliente = new Cliente();

        Integer riesgoCli = riesgoService.getRiesgoBCRA();
        if (riesgoCli == 1 || riesgoCli == 2) {
            cliente.setHabilitadoOnline(true);
        }
        else {
            cliente.setHabilitadoOnline(false);
        }

        Usuario user = modelMapper.map(usuarioService.findByUser(clienteDTO.getNombre()), Usuario.class);

        if (user==null){
            throw new BadRequestException("El usuario: " + clienteDTO.getNombre() + " no existe");
        }

        List<Obra> obraList = new ArrayList<>();

        for(ObraRequestDTO obra: clienteDTO.getObras()){
            Obra o = modelMapper.map(obraService.findById(obra.getId()), Obra.class);

            if(o==null){
                throw new DataNotFoundException("La obra con id: " + obra.getId() + " no existe");
            }else if(!obra.getTipo().equals(o.getTipo())){
                throw new BadRequestException("El tipo de obra no es correcto");
            }

            obraList.add(o);
        }

        cliente.setObras(obraList);
        cliente.setMail(clienteDTO.getMail());
        cliente.setUser(user);
        cliente.setRazonSocial(clienteDTO.getRazonSocial());
        cliente.setCuit(clienteDTO.getCuit());
        
        return modelMapper.map(clienteRepo.save(cliente), ClienteDTO.class);
    }

    @Override
    public ClienteDTO buscarCliente(Integer id) {
       Optional<Cliente> cli = this.clienteRepo.findById(id);
       if (!cli.isPresent()) {
            throw new DataNotFoundException("El cliente con id: " + id + " no existe");
       }
       return modelMapper.map(cli.get(), ClienteDTO.class);
    }

    @Override
    public ClienteDTO buscarCliente(String cuit) {
        Optional<Cliente> cliente = Optional.ofNullable(clienteRepo.findByCuit(cuit));

        if(!cliente.isPresent()){
            throw new DataNotFoundException("El cliente con cuit: " + cuit + " no existe");
        }

        return modelMapper.map(cliente.get(), ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> buscarClientes() {
        return listMapper.mapList(clienteRepo.findAll(), ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> buscarClientes(String razonSocial) {
        Optional<List<Cliente>> clientes = Optional.ofNullable(clienteRepo.findByRazonSocial(razonSocial));
        return listMapper.mapList(clientes.get(), ClienteDTO.class);
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO cli) {
        Optional<Cliente> cliente = clienteRepo.findById(cli.getId());

        if(!cliente.isPresent()){
            throw new DataNotFoundException("El cliente con id: " + cli.getId() + " no existe");
        }

        return modelMapper.map(clienteRepo.save(modelMapper.map(cli, Cliente.class)), ClienteDTO.class);
    }

    // Tiene obras osea que tiene pedidos? TODO 
    @Override
    public void borrarCliente(Integer id) {
        Optional<Cliente> cli = this.clienteRepo.findById(id);
        if (cli.get().getObras().isEmpty()) {
            this.clienteRepo.deleteById(id);  
        }
        else {
            cli.get().setFechaBaja(new Date());
            this.clienteRepo.save(cli.get());
        }
    }
    
}
