package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto_venta")
@Data
public class ProductoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
