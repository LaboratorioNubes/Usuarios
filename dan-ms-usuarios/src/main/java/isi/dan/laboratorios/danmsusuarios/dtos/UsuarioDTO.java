package isi.dan.laboratorios.danmsusuarios.dtos;

import isi.dan.laboratorios.danmsusuarios.domain.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String user, password;
    private TipoUsuario tipoUsuario;
}
