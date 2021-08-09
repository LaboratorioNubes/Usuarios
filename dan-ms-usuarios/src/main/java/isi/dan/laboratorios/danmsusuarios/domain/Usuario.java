package isi.dan.laboratorios.danmsusuarios.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    private Integer id;
    private String user, password;
    private TipoUsuario tipoUsuario;
}
