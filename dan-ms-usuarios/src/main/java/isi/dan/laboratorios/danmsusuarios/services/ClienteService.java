package isi.dan.laboratorios.danmsusuarios.services;

import java.util.Optional;

import isi.dan.laboratorios.danmsusuarios.domain.Cliente;

public interface ClienteService {

    public Optional<Cliente> buscarCliente(Integer id);
    public Optional<Cliente> buscarCliente(String cuit);

    public Iterable<Cliente> buscarClientes();
    public Optional<Iterable<Cliente>> buscarClientes(String razonSocial);

    public Cliente guardarCliente(Cliente cli);
    public Optional<Cliente> actualizarCliente(Cliente cli, Integer id);
    public void borrarCliente(Integer id);

}
