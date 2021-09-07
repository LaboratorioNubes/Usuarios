package isi.dan.laboratorios.danmsusuarios.services.impl;

import isi.dan.laboratorios.danmsusuarios.dtos.UsuarioDTO;
import isi.dan.laboratorios.danmsusuarios.repositories.UsuarioRepository;
import isi.dan.laboratorios.danmsusuarios.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UsuarioDTO findByUser(String user) {
        return modelMapper.map(usuarioRepository.findByUser(user), UsuarioDTO.class);
    }
}
