package isi.dan.laboratorios.danmsusuarios.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
