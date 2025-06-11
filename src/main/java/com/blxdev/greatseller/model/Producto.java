package com.blxdev.greatseller.model;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;//Nombre comercial
    private String descripcion;//
    private BigDecimal precio_venta;
    private BigDecimal precio_costo;
    private Integer stock;
    private String forma_farmaceutica;//Tablet, capsula, jarabe, etc.
    private String concentracion;//Ej. 500 mg, 5%
    private String presentacion;//Caja, frasco, etc.
    private Boolean requiere_receta;
    private String registro_sanitario;
    private Boolean estado;//Si esta disponible para la venta
    private String uso_terapeutico;//Indicacion general(dolor, fiebre, etc.)
    private String condicion_almacenamiento;//Refrigerado, seco
    @CreationTimestamp
    private LocalDateTime fecha_vencimiento;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
    @CreationTimestamp
    private LocalDateTime fecha_registro;
    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;//Laboratorio fabricante

}
