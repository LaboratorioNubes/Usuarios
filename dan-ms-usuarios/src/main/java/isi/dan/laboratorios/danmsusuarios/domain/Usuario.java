package isi.dan.laboratorios.danmsusuarios.domain;

import javax.persistence.*;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String user;
    private String password;

    @OneToOne
    private TipoUsuario tipoUsuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(Integer id, String user, String password, TipoUsuario tipoUsuario) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {
    }
}
