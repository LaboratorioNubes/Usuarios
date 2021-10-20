package isi.dan.laboratorios.danmsusuarios.services.impl;

import isi.dan.laboratorios.danmsusuarios.domain.Cliente;
import isi.dan.laboratorios.danmsusuarios.domain.Obra;
import isi.dan.laboratorios.danmsusuarios.domain.TipoObra;
import isi.dan.laboratorios.danmsusuarios.dtos.ObraDTO;
import isi.dan.laboratorios.danmsusuarios.dtos.requests.ObraRequestDTO;
import isi.dan.laboratorios.danmsusuarios.repositories.ClienteRepository;
import isi.dan.laboratorios.danmsusuarios.repositories.ObraRepository;
import isi.dan.laboratorios.danmsusuarios.repositories.TipoObraRepository;
import isi.dan.laboratorios.danmsusuarios.services.ObraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ObraServiceImpl implements ObraService {

    @Autowired
    ObraRepository obraRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    TipoObraRepository tipoObraRepository;

    @Override
    public ObraDTO findById(int id) {
        return modelMapper.map(obraRepository.findById(id), ObraDTO.class);
    }

    @Override
    public void crear(ObraRequestDTO obra) {
        Optional<Cliente> cliente = clienteRepository.findById(obra.getCliente());

        Optional<TipoObra> tipoObra = tipoObraRepository.findById(1);

        Obra obraNueva = new Obra();
        obraNueva.setCliente(cliente.get());
        obraNueva.setTipo(tipoObra.get());
        obraNueva.setNombre(obra.getNombre());
        obraNueva.setDireccion(obra.getDireccion());
        obraNueva.setTelefono(obra.getTelefono());
        obraNueva.setDescripcion(obra.getDescripcion());

        cliente.get().getObras().add(obraRepository.save(obraNueva));
        clienteRepository.save(cliente.get());

    }

    @Override
    public List<String> getObraPorCliente(Integer idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        List<Obra> obras = cliente.get().getObras();
        List<String> resultado = new ArrayList<>();

        for(Obra o: obras){
            resultado.add(o.getNombre());
        }

        return resultado;
    }
}
