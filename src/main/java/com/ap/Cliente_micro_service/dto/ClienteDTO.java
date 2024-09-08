package com.ap.Cliente_micro_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteDTO {
    private String id;

    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    @Email(message = "El correo electrónico no es válido")
    private String email;

    @NotNull(message = "El teléfono no puede ser nulo")
    private String telefono;

    private String direccion;
}
