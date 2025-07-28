package com.blxdev.greatseller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ProveedorUpdateDTO {

    @Size(min = 3, max = 150, message = "La dirección debe contener entre 3 y 150 caracteres.")
    private String direccion;

    @Email(message = "El formato del email no es válido.")
    private String email;

    @Pattern(regexp = "^[0-9]{5,15}$", message = "El NIT debe contener entre 5 y 15 caracteres numericos")
    private String nit;

    private String nombre;
    private String razon_social;

    @Pattern(regexp = "^[0-9]{7,10}$", message = "El telefono debe contener entre 7 y 10 caractéres numéricos.")
    private String telefono;

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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
