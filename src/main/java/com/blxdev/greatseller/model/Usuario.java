package com.blxdev.greatseller.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String usuario;
    private String clave;
    private String rol;

    @OneToMany(mappedBy = "usuario")
    private List<Venta> ventas;
}
