package isi.dan.laboratorios.danmsusuarios.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraClienteRequestDTO {

    @NotNull(message = "El id de la obra no puede ser nulo")
    private int id;

    @NotNull(message = "El tipo de obra no puede ser nulo")
    @NotBlank(message = "El tipo de obra no puede ser vacio")
    private String tipo;
}
