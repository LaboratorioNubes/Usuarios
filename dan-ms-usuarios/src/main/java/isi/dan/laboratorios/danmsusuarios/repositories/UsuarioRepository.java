package isi.dan.laboratorios.danmsusuarios.repositories;

import isi.dan.laboratorios.danmsusuarios.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(
            "SELECT u FROM Usuario u\n" +
            "WHERE u.user = :name"
    )
    public Usuario findByUser(@Param("name") String name);
}
