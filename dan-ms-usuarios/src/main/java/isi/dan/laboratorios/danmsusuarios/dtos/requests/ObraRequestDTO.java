package isi.dan.laboratorios.danmsusuarios.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraRequestDTO {
    private int cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;
}
