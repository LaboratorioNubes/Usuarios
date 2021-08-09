package isi.dan.laboratorios.danmsusuarios.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Obra {
    private Integer id;
	private String descripcion;
	private Float latitud;
	private Float longitud;
	private String direccion;
	private Integer superficie;
	private TipoObra tipo;
	private Cliente cliente;
}
