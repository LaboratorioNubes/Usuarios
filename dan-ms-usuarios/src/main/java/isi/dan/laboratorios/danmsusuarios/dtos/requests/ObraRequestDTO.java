package isi.dan.laboratorios.danmsusuarios.dtos.requests;

public class ObraRequestDTO {
    private int cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public ObraRequestDTO(int cliente, String nombre, String direccion, String telefono, String descripcion) {
        this.cliente = cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public ObraRequestDTO() {
    }


}
