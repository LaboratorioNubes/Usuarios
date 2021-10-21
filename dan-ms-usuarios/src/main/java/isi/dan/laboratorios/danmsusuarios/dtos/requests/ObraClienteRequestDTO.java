package isi.dan.laboratorios.danmsusuarios.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ObraClienteRequestDTO {

    @NotNull(message = "El id de la obra no puede ser nulo")
    private int id;

    @NotNull(message = "El tipo de obra no puede ser nulo")
    @NotBlank(message = "El tipo de obra no puede ser vacio")
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ObraClienteRequestDTO(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public ObraClienteRequestDTO() {
    }
}
