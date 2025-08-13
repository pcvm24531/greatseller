package com.blxdev.greatseller.dto;

import com.blxdev.greatseller.model.Venta;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

public class ClienteCreateDTO {

    @NotBlank(message = "Este campo es obligatorio")
    @Size(min=5, max = 250, message = "El nombre debe contener entre 5 y 250 caracteres!")
    private String nombre;

    @Pattern(regexp = "^[0-9]{7,10}$", message = "El telefono debe contener entre 7 y 10 digitos.")
    private String telefono;

    @Email(message = "Ingrese un email válido.")
    private String email;

    @Pattern(regexp = "[0-9]{5,15}", message = "El NIT debe contener entre 5 y 15 dígitos.")
    private String nit_ci;

    @Size(min = 5, max = 250, message = "La dirección debe contener entre 5 y 250 caracteres.")
    private String direccion;

    private Boolean activo;
    @CreationTimestamp
    private LocalDateTime fechaRegistro;
    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNit_ci() {
        return nit_ci;
    }

    public void setNit_ci(String nit_ci) {
        this.nit_ci = nit_ci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
