package com.blxdev.greatseller.controller;

import com.blxdev.greatseller.dto.ProveedorCreateDTO;
import com.blxdev.greatseller.dto.ProveedorUpdateDTO;
import com.blxdev.greatseller.model.Proveedor;
import com.blxdev.greatseller.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller/proveedor")
public class ProveedorController {

    @Autowired
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService){
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        List<Proveedor> proveedors = proveedorService.findAll();
        return ResponseEntity.ok(proveedors);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody ProveedorCreateDTO proveedorCreateDTO){
        Proveedor proveedor = proveedorService.save(proveedorCreateDTO);
        return ResponseEntity.ok(proveedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Proveedor proveedor = proveedorService.read(id);
        return ResponseEntity.ok(proveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Validated @RequestBody ProveedorUpdateDTO proveedorUpdateDTO){
        Proveedor proveedor = proveedorService.update(id, proveedorUpdateDTO);
        return ResponseEntity.ok(proveedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        proveedorService.delete(id);
    }
}
