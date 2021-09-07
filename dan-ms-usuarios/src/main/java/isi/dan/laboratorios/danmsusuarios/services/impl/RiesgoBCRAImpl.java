package isi.dan.laboratorios.danmsusuarios.services.impl;

import org.springframework.stereotype.Service;

import isi.dan.laboratorios.danmsusuarios.dtos.ClienteDTO;
import isi.dan.laboratorios.danmsusuarios.services.RiesgoBCRAService;

@Service
public class RiesgoBCRAImpl implements RiesgoBCRAService {

    @Override
    public Integer getRiesgoBCRA() {
        return (int) (Math.random() * 6 + 1);
    }
    
}
