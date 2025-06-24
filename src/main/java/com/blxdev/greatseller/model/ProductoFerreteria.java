package com.blxdev.greatseller.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "producto_ferreteria")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductoFerreteria extends Producto{

    @Column(length = 100)
    private String marca;

}
