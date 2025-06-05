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
    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id")
    private Producto producto;
    @ManyToOne
    @MapsId("id_fabricante")
    @JoinColumn(name = "id")
    private Fabricante fabricante;

    @CreationTimestamp
    private LocalDateTime fecha_registro;
}
