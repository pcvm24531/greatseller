package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "producto_ubicacion")
@Data
public class ProductoUbicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String almacen;//Nombre del almacen, galpón, depósito, etc.

    @Column(length = 100)
    private String sector;//estante, pasillo, sector, etc.

    @Column(length = 100)
    private String estante;//

    @Column(length = 100)
    private String nivel;

    @Column(nullable = false)
    private Integer cantidad;//Cantidad de articulos en este lugar específico

    @Column(length = 250)
    private String observacion;//Observciones o detalles adicionales

    //Relacion con producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

}
