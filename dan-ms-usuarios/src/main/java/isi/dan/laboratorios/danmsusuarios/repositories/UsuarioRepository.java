package isi.dan.laboratorios.danmsusuarios.repositories;

import isi.dan.laboratorios.danmsusuarios.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
