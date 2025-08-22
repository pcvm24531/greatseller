package com.blxdev.greatseller.dto;

import com.blxdev.greatseller.model.Venta;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class ClienteUpdateDTO {

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

    @Column
    private Boolean activo;

    @CreationTimestamp
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;

}
