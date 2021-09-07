package isi.dan.laboratorios.danmsusuarios.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuarioDTO {
    private Integer id;
    private String tipo;
}
