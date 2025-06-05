package com.blxdev.greatseller.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "producto_ubicacion")
public class ProductoUbicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Relación con producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_producto")
    private Producto producto;

    //Relacion con ubicación
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_ubicacion")
    private Ubicacion ubicacion;

    //Datos farmaceuticos
    private String lote;
    private Double precio_compra;
    private Double precio_venta;

    //Control de inventario
    private Integer stock;
    private Integer stock_minimo;
    private Integer stock_maximo;

    //Fechas
    private LocalDate fecha_ingreso;
    private LocalDate fecha_vencimiento;

    //Auditoria básica
    private String creado_por;
    private LocalDate fecha_creacion;
    private String modificado_por;
    private LocalDate fecha_modificacion;

}
