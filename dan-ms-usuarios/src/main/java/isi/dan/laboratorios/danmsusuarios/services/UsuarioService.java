package isi.dan.laboratorios.danmsusuarios.services;

import isi.dan.laboratorios.danmsusuarios.dtos.UsuarioDTO;

public interface UsuarioService {
    public UsuarioDTO findByUser(String user);
}
