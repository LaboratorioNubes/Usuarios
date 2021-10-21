package isi.dan.laboratorios.danmsusuarios.dtos;

public class TipoUsuarioDTO {
    private Integer id;
    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoUsuarioDTO(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoUsuarioDTO() {
    }
}
