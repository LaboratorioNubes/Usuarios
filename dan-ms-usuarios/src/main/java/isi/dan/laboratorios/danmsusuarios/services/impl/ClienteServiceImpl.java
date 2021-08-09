package isi.dan.laboratorios.danmsusuarios.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    Cliente cliNuevo; 

    @Override
    public Cliente guardarCliente(ClienteDTO cli) {
        Integer riesgoCli = riesgoService.getRiesgoBCRA(cli);
        if (riesgoCli == 1 || riesgoCli == 2) {
            cli.setHabilitadoOnline(true);
        }
        else {
            cli.setHabilitadoOnline(false);
        }

        cliNuevo = new Cliente();
        cliNuevo.setRazonSocial(cli.getRazonSocial());
        cliNuevo.setCuit(cli.getCuit());
        cliNuevo.setMail(cli.getMail());
        cliNuevo.setMaxCuentaCorriente(cli.getMaxCuentaCorriente());
        cliNuevo.setUser(cli.getUser());
        cliNuevo.setObras(cli.getObras());
        
        return this.clienteRepo.save(cliNuevo);
    }

    @Override
    public Optional<Cliente> buscarCliente(Integer id) {
       Optional<Cliente> cli = this.clienteRepo.findById(id);
       if (cli.get().getFechaBaja() == null) {
            return cli;
       }
       return Optional.empty();
    }

    @Override
    public Optional<Cliente> buscarCliente(String cuit) {
        // TODO Not possible without bdd
        return null;
    }

    @Override
    public Iterable<Cliente> buscarClientes() {
        return this.clienteRepo.findAll();
    }

    @Override
    public Optional<Iterable<Cliente>> buscarClientes(String razonSocial) {
        // TODO Not possible without bdd
        return null;
    }

    @Override
    public Optional<Cliente> actualizarCliente(ClienteDTO cli, Integer id) {
        // TODO Not possible without bdd
        return null;
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
