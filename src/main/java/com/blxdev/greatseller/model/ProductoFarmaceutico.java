package com.blxdev.greatseller.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

@Entity
@Table(name = "producto_farmaceutico")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductoFarmaceutico extends Producto{

    @Column(length = 100)
    private String formaFarmaceutica;//Tableta, capsula, jarabe, etc.

    @Column(length = 100)
    private String consentracion;//Ejm 500 mg, 5%

    @Column(length = 100)
    private String composicion;

    @Column(length = 100)
    private String dosificacion;

    @Column(length = 100)
    private String presentacion;//caja, frasco, etc

    private Boolean requiereReceta;

    @Column(length = 100)
    private String registroSanitario;

    @Column(length = 255)
    private String usoTerapeutico;//Indicacion general (dolor, fiebre, etc)

    @Column(length = 255)
    private String condicionAlmacenamiento;//refrigerado, seco, etc.

    private LocalDate fechaVencimiento;
}
