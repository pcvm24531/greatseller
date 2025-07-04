package com.blxdev.greatseller.controller;

import com.blxdev.greatseller.model.Producto;
import com.blxdev.greatseller.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller/productos")
public class ProductoController {

    @Autowired
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoService.findAll();
    }

}
