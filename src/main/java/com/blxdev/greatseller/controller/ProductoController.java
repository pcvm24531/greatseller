package com.blxdev.greatseller.controller;

import com.blxdev.greatseller.model.Producto;
import com.blxdev.greatseller.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service){
        this.service = service;
    }

    @GetMapping
    public List<Producto> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Long id){
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto){
        return service.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto){
        return service.getById(id)
                .map( p -> {
                    producto.setId(id);
                    return ResponseEntity.ok(service.save(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if( service.getById(id).isPresent() ){
            service.delete(id);
            return  ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
