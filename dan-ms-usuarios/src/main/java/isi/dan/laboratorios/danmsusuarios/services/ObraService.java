package isi.dan.laboratorios.danmsusuarios.services;

import isi.dan.laboratorios.danmsusuarios.domain.Obra;
import isi.dan.laboratorios.danmsusuarios.dtos.ObraDTO;
import isi.dan.laboratorios.danmsusuarios.dtos.requests.ObraRequestDTO;

import java.util.List;

public interface ObraService {
    ObraDTO findById(int id);
    void crear(ObraRequestDTO obra);
    List<String> getObraPorCliente(Integer idCliente);
}
