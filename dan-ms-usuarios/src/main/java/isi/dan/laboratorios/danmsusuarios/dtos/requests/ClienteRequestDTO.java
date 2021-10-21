package isi.dan.laboratorios.danmsusuarios.dtos.requests;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClienteRequestDTO {
    private String nombre;

    @NotNull(message = "Mail es un campo obligatorio")
    @NotEmpty(message = "Mail es un campo obligatorio")
    private String mail;

    @NotNull(message = "Contrasena es un campo obligatorio")
    @NotEmpty(message = "Contrasena es un campo obligatorio")
    private String contrasena;

    private String razonSocial;
    private String cuit;

    @NotEmpty(message = "Debe indicar por lo menos una obra")
    private List<@Valid ObraClienteRequestDTO> obras;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public List<ObraClienteRequestDTO> getObras() {
        return obras;
    }

    public void setObras(List<ObraClienteRequestDTO> obras) {
        this.obras = obras;
    }

    public ClienteRequestDTO(String nombre, String mail, String contrasena, String razonSocial, String cuit, List<@Valid ObraClienteRequestDTO> obras) {
        this.nombre = nombre;
        this.mail = mail;
        this.contrasena = contrasena;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.obras = obras;
    }

    public ClienteRequestDTO() {
    }
}
