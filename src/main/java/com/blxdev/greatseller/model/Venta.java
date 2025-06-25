package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venta")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String observacion;

    @Column(nullable = false)
    private BigDecimal total;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    //Usuario que realizó la venta
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    //Cliente al que se vendio
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    //Relacion con tabla relacional ProductoVenta
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    private List<ProductoVenta> productos;

}
