package isi.dan.laboratorios.danmsusuarios.domain;

import javax.persistence.*;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Obra() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Obra(Integer id, String nombre, String direccion, String telefono, String descripcion, TipoObra tipo, Cliente cliente) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoObra getTipo() {
		return tipo;
	}

	public void setTipo(TipoObra tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@OneToOne
	private Cliente cliente;
}
