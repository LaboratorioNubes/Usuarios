package isi.dan.laboratorios.danmsusuarios.services.impl;

import org.springframework.stereotype.Service;

import isi.dan.laboratorios.danmsusuarios.domain.Cliente;
import isi.dan.laboratorios.danmsusuarios.services.RiesgoBCRAService;

@Service
public class RiesgoBCRAImpl implements RiesgoBCRAService {

    @Override
    public Integer getRiesgoBCRA(Cliente c) {
        return (int) (Math.random() * 6 + 1);
    }
    
}
