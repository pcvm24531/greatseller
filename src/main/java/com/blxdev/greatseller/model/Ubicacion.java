package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ubicacion")
@Data
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idTienda")
    private Tienda tienda;

    @OneToMany(mappedBy = "ubicacion")
    private List<ProductoUbicacion> productos;

}
