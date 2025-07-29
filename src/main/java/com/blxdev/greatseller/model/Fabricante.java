package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fabricante")
@Data
public class Fabricante {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String pais;
    private String telefono;
    private String email;
    @CreationTimestamp
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "fabricante")
    private List<ProductoFabricante> productoFabricantes;//Laboratorio fabricante

}
