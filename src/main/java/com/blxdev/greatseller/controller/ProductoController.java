package com.blxdev.greatseller.controller;

import com.blxdev.greatseller.model.Producto;
import com.blxdev.greatseller.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoService.findAll();
    }

}
