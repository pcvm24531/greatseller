package com.blxdev.greatseller.service;

import com.blxdev.greatseller.dto.ClienteCreateDTO;
import com.blxdev.greatseller.model.Cliente;
import com.blxdev.greatseller.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAllActivos(){
        return clienteRepository.findAllByActivoTrue();
    }

    public Cliente save(ClienteCreateDTO clienteCreateDTO){
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteCreateDTO.getNombre());
        cliente.setDireccion(cliente.getDireccion());
        cliente.setNit_ci(clienteCreateDTO.getNit_ci());
        cliente.setTelefono(clienteCreateDTO.getTelefono());
        cliente.setEmail(clienteCreateDTO.getEmail());
        return clienteRepository.save(cliente);
    }
}
