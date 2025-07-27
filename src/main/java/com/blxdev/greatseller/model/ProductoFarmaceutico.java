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
    private String formaFarmaceutica;//Tableta o comprimido, capsula, jarabe, crema, inyextable, gotas etc.

    @Column(length = 100)
    private String concentracion;//Ejm 500 mg, 5%

    @Column(length = 100)
    private String composicion;

    @Column(length = 100)
    private String dosificacion;//1 tableta cada ocho horas

    @Column(length = 100)
    private String administracion;//oral, tópica, intramuscular, intravenosa, oftàlmologica, rectal, sublingual

    private Boolean requiereReceta;

    @Column(length = 100)
    private String registroSanitario;

    @Column(length = 255)
    private String usoTerapeutico;//Indicacion general (dolor, fiebre, etc)

    @Column(length = 255)
    private String condicionAlmacenamiento;//refrigerado, seco, etc.

    @Column(length = 100)
    private String lote;

    @Column(length = 255)
    private String contraindicacion;

    @Column(length = 255)
    private String clasificacion;//Analgésico, Antibiótico, Antiinflamatorio, Citamina, Producto natural, producto de cuidado personal(shampoo, cremas)

    private LocalDate fechaVencimiento;
}
