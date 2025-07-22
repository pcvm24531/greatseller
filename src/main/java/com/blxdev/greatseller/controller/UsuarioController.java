package com.blxdev.greatseller.controller;

import com.blxdev.greatseller.dto.UsuarioDTO;
import com.blxdev.greatseller.model.Usuario;
import com.blxdev.greatseller.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> obtenerTodos(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> crear(@Validated @RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioService.save(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public Usuario modificar(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.delete(id);
    }
}
