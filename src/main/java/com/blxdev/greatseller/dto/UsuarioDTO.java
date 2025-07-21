package com.blxdev.greatseller.dto;

import jakarta.validation.constraints.*;

public class UsuarioDTO {
    @NotNull(message = "El nombre es obligatorio")
    @Size(min = 2, max = 30, message = "El nombre debe tener entre 2 y 30 caracteres.")
    private String nombre;
}
