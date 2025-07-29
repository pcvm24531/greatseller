package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "producto_foto")
@Data
public class ProductoFoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String url;

    @Column(length = 255)
    private String descripcion;

    @Column(name = "orden")
    private Integer orden;//Define la posicion de la foto

    //Relación con producto
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @CreationTimestamp
    private LocalDateTime fechaRegistro;
}
