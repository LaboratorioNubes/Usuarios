package isi.dan.laboratorios.danmsusuarios.repositories;

import isi.dan.laboratorios.danmsusuarios.domain.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer> {
}

