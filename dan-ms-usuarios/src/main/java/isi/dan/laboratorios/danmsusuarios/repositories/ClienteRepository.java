package isi.dan.laboratorios.danmsusuarios.repositories;

import org.springframework.stereotype.Repository;

import frsf.isi.dan.InMemoryRepository;
import isi.dan.laboratorios.danmsusuarios.domain.Cliente;

@Repository
public class ClienteRepository extends InMemoryRepository<Cliente> {

    @Override
    public Integer getId(Cliente c) {
        return c.getId();
    }

    @Override
    public void setId(Cliente c, Integer id) {
        c.setId(id);       
    }
    
}
