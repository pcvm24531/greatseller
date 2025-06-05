package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String nit_ci;
    private String direccion;
    @CreationTimestamp
    private LocalDateTime fecha_registro;
    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;
}
