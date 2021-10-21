package isi.dan.laboratorios.danmsusuarios.dtos;

import isi.dan.laboratorios.danmsusuarios.domain.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UsuarioDTO {
    private Integer id;
    private String user, password;
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

    public UsuarioDTO(Integer id, String user, String password, TipoUsuario tipoUsuario) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioDTO() {
    }
}
