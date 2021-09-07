package isi.dan.laboratorios.danmsusuarios.services.impl;

import isi.dan.laboratorios.danmsusuarios.dtos.ObraDTO;
import isi.dan.laboratorios.danmsusuarios.repositories.ObraRepository;
import isi.dan.laboratorios.danmsusuarios.services.ObraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraServiceImpl implements ObraService {

    @Autowired
    ObraRepository obraRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ObraDTO findById(int id) {
        return modelMapper.map(obraRepository.findById(id), ObraDTO.class);
    }
}
