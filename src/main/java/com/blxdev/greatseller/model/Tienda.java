package com.blxdev.greatseller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "tienda")
@Data
public class Tienda {

    @Id
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
    @CreationTimestamp
    private LocalDate fechaRegistro;
}
