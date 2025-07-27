package com.blxdev.greatseller.service;

import com.blxdev.greatseller.dto.ProveedorCreateDTO;
import com.blxdev.greatseller.exceptions.GlobalExceptionHandler;
import com.blxdev.greatseller.model.Proveedor;
import com.blxdev.greatseller.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository){
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> findAll(){
        return proveedorRepository.findAll();
    }

    public Proveedor save(ProveedorCreateDTO proveedorCreateDTO){
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(proveedorCreateDTO.getNombre());
        proveedor.setEmail(proveedorCreateDTO.getEmail());
        proveedor.setRazon_social(proveedorCreateDTO.getRazon_social());
        proveedor.setDireccion(proveedorCreateDTO.getDireccion());
        return proveedorRepository.save(proveedor);
    }

}
