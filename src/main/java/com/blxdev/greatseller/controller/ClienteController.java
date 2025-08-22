package com.blxdev.greatseller.controller;

import com.blxdev.greatseller.dto.ClienteCreateDTO;
import com.blxdev.greatseller.dto.ClienteUpdateDTO;
import com.blxdev.greatseller.model.Cliente;
import com.blxdev.greatseller.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller/cliente")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    public ClienteController( ClienteService clienteService ){
        this.clienteService = clienteService;
    }
    @GetMapping
    public ResponseEntity<List> findAllActivos(){
        List <Cliente> clientes = clienteService.findAllActivos();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Validated @RequestBody ClienteCreateDTO clienteCreateDTO){
        Cliente newCliente = clienteService.create(clienteCreateDTO);
        return ResponseEntity.ok(newCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> read(@PathVariable Long id){
        return ResponseEntity.ok( clienteService.read(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity <Cliente> update(@Validated @RequestBody ClienteUpdateDTO clienteUpdateDTO, @PathVariable Long id){
        return ResponseEntity.ok(clienteService.update(clienteUpdateDTO, id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
}
