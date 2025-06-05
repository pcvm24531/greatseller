package com.blxdev.greatseller.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_venta")
public class ProductoVenta {
    @EmbeddedId
    private ProductoVentaId id = new ProductoVentaId();
}
