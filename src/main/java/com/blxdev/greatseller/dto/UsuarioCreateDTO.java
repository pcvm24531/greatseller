package com.blxdev.greatseller.dto;

import jakarta.validation.constraints.*;

public class UsuarioCreateDTO {
    @NotNull(message = "El nombre es obligatorio.")
    @Size(min = 2, max = 30, message = "El nombre debe tener entre 2 y 30 caracteres.")
    private String nombre;

    @NotNull(message="El apellido es obligatorio.")
    @Size(min=2, max=20, message = "El apellido debe tener entre 2 y 50 caracteres.")
    private String apellido;

    @NotNull(message = "Direccion es un campo obligatorio.")
    @Size(min=10, max = 200, message = "Direccion debe tener almeenos 10 carcteres.")
    private String direccion;

    @NotNull(message = "El username es obligatorio.")
    @Size(min = 4, max = 20, message = "El username debe tener entre 4 y 20 caracateres.")
    private String username;

    @NotNull(message = "EL password es obligatorio.")
    @Size(min = 5, max = 15, message = "EL password debe tener entre 5 y 15 caracteres.")
    private String password;

    @NotNull(message = "El cargo del empleado es obligatorio.")
    private String rol;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
