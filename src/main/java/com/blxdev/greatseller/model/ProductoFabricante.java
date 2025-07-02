package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "producto_fabricante")
public class ProductoFabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime fechaRegistro;

    //Relacion con producto
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    //Relación Ubicacion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFabricante", nullable = false)
    private Fabricante fabricante;
}
