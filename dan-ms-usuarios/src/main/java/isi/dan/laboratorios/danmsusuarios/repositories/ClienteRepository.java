package isi.dan.laboratorios.danmsusuarios.repositories;

import isi.dan.laboratorios.danmsusuarios.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import isi.dan.laboratorios.danmsusuarios.domain.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(
        "SELECT c FROM Cliente c\n" +
        "WHERE c.cuit = :cuit"
    )
    Cliente findByCuit(@Param("cuit") String cuit);


    @Query(
        "SELECT c FROM Cliente c\n" +
        "WHERE c.razonSocial = :razonSocial"
    )
    List<Cliente> findByRazonSocial(@Param("razonSocial") String razonSocial);
}
