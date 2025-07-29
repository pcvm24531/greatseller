package com.blxdev.greatseller.dto;

import jakarta.validation.constraints.*;

public class ProveedorCreateDTO {

    @NotNull(message = "El combre es obligatorio.")
    @Size(min=2, max = 30, message = "El nombre debe contener entre 2 y 30 caracteres.")
    private String nombre;

    @Pattern(regexp = "^[0-9]{7,10}$", message = "El telefono debe contener entre 7 y 10 digitos")
    private String telefono;

    @NotBlank(message = "La direccion es obligatoria")
    @Size(min = 5, max = 150, message = "La direccion debe contener entre 5 y 150 caracteres.")
    private String direccion;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe tener un formato valido")
    private String email;

    @NotBlank(message = "Este campo es  requerido")
    private String razon_social;

    @Pattern(regexp = "^[0-9]{5,15}$", message = "El NIT debe contener entre 5 y 15 caracteres numericos")
    @NotBlank(message = "El NIT es requerido.")
    private String nit;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
