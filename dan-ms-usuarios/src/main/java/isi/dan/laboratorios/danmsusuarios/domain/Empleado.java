package isi.dan.laboratorios.danmsusuarios.domain;

import javax.persistence.*;

@Entity
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String mail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Empleado(Integer id, String mail, Usuario user) {
		this.id = id;
		this.mail = mail;
		this.user = user;
	}

	public Empleado() {
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	@OneToOne
	private Usuario user;
	
}
