package isi.dan.laboratorios.danmsusuarios.dtos;

import java.sql.Date;
import java.util.List;

import isi.dan.laboratorios.danmsusuarios.domain.Obra;
import isi.dan.laboratorios.danmsusuarios.domain.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String razonSocial;
    private String cuit;
    private String mail;
    private Double maxCuentaCorriente;
    private Boolean habilitadoOnline;
    private Usuario user;
    private List<Obra> obras;

    private Date fechaBaja;    
}
