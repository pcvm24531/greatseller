package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Ubicacion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String pasillo;
    private String estante;
    private String nivel;
    private String posicion;
    private String descripcion;
    @CreationTimestamp
    private LocalDateTime fecha_registro;

    @ManyToOne
    @JoinColumn(name = "id_tienda")
    private Tienda tienda;

}
