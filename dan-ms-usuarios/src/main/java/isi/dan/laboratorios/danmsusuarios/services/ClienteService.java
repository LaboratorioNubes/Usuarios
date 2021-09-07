package isi.dan.laboratorios.danmsusuarios.services;

import java.util.List;
import isi.dan.laboratorios.danmsusuarios.dtos.ClienteDTO;
import isi.dan.laboratorios.danmsusuarios.dtos.requests.ClienteRequestDTO;

public interface ClienteService {
    ClienteDTO buscarCliente(Integer id);
    ClienteDTO buscarCliente(String cuit);
    List<ClienteDTO> buscarClientes();
    List<ClienteDTO> buscarClientes(String razonSocial);
    ClienteDTO guardarCliente(ClienteRequestDTO cliente);
    ClienteDTO actualizarCliente(ClienteDTO cli);
    void borrarCliente(Integer id);
}
