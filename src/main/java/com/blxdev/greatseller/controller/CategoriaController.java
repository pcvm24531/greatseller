package com.blxdev.greatseller.controller;

import com.blxdev.greatseller.dto.CategoriaDTO;
import com.blxdev.greatseller.model.Categoria;
import com.blxdev.greatseller.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller/categorias")
public class CategoriaController {

    @Autowired
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAllActivos(){
        List<Categoria> categorias = categoriaService.findAllActivos();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaService.save(categoriaDTO);
        return ResponseEntity.ok( categoria );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        return ResponseEntity.ok( categoriaService.read(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Validated @RequestBody CategoriaDTO categoriaDTO){
        return ResponseEntity.ok( categoriaService.update(id, categoriaDTO) );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoriaService.delete(id);
    }

}
