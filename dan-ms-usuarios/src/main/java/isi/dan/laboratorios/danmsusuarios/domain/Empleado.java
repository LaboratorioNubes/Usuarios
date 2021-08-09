package isi.dan.laboratorios.danmsusuarios.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    
    private Integer id;
	private String mail;
	private Usuario user;
	
}
