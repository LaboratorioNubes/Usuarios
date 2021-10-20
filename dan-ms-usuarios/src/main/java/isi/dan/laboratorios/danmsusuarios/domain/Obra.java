package isi.dan.laboratorios.danmsusuarios.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Obra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String descripcion;

	@OneToOne
	private TipoObra tipo;

	@OneToOne
	private Cliente cliente;
}
