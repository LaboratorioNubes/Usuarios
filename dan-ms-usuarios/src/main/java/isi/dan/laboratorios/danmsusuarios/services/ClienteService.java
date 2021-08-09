package isi.dan.laboratorios.danmsusuarios.services;

import java.util.Optional;

import isi.dan.laboratorios.danmsusuarios.domain.Cliente;
import isi.dan.laboratorios.danmsusuarios.dtos.ClienteDTO;

public interface ClienteService {

    public Optional<Cliente> buscarCliente(Integer id);
    public Optional<Cliente> buscarCliente(String cuit);

    public Iterable<Cliente> buscarClientes();
    public Optional<Iterable<Cliente>> buscarClientes(String razonSocial);

    public Cliente guardarCliente(ClienteDTO cli);
    public Optional<Cliente> actualizarCliente(ClienteDTO cli, Integer id);
    public void borrarCliente(Integer id);

}
