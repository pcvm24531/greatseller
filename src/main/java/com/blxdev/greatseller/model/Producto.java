package com.blxdev.greatseller.model;

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 100, nullable = false)
    private String codigo;

    @Column(nullable = false, length = 255)
    private String nombre;//Nombre comercial

    @Column(length = 500)
    private String descripcion;//

    @Column(name = "precio_costo", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioCosto;

    @Column(name = "precio_venta", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean estado;//Si esta disponible para la venta

    @CreationTimestamp
    private LocalDateTime fechaRegistro;





    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor proveedor;

    @OneToMany(mappedBy = "producto")
    private List<ProductoFoto> productoFotos;

    @OneToMany(mappedBy = "producto")
    private List<ProductoUbicacion> productoUbicaciones;

    @OneToMany(mappedBy = "producto")
    private List<ProductoVenta> productoVentas;

    @OneToMany(mappedBy = "producto")
    private List<ProductoFabricante> productoFabricantes;//Laboratorio fabricante
}
