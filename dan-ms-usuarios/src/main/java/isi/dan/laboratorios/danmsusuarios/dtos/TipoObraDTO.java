package isi.dan.laboratorios.danmsusuarios.dtos;

public class TipoObraDTO {
    private Integer id;
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoObraDTO(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public TipoObraDTO() {
    }
}
