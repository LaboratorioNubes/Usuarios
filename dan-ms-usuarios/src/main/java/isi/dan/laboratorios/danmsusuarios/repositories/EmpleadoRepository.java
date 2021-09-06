package isi.dan.laboratorios.danmsusuarios.repositories;

import isi.dan.laboratorios.danmsusuarios.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
