package com.blxdev.greatseller.model;

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Column(name = "precio_venta", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "precio_costo", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioCosto;

    @Column(nullable = false)
    private Integer stock;
    private String formaFarmaceutica;//Tablet, capsula, jarabe, etc.
    private String concentracion;//Ej. 500 mg, 5%
    private String presentacion;//Caja, frasco, etc.
    private Boolean requiereReceta;
    private String registroSanitario;
    private Boolean estado;//Si esta disponible para la venta
    private String usoTerapeutico;//Indicacion general(dolor, fiebre, etc.)
    private String condicion_almacenamiento;//Refrigerado, seco

    private LocalDateTime fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;
    @CreationTimestamp
    private LocalDateTime fecha_registro;
    @ManyToOne
    @JoinColumn(name = "idFabricante")
    private Fabricante fabricante;//Laboratorio fabricante

}
