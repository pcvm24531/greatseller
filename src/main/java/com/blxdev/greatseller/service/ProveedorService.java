package com.blxdev.greatseller.service;

import com.blxdev.greatseller.dto.ProveedorCreateDTO;
import com.blxdev.greatseller.dto.ProveedorUpdateDTO;
import com.blxdev.greatseller.exceptions.CrudExceptions;
import com.blxdev.greatseller.model.Proveedor;
import com.blxdev.greatseller.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository){
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> findAllActivos(){
        return proveedorRepository.findAllByActivoTrue();
    }

    public Proveedor save(ProveedorCreateDTO proveedorCreateDTO){
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(proveedorCreateDTO.getNombre());
        proveedor.setEmail(proveedorCreateDTO.getEmail());
        proveedor.setRazon_social(proveedorCreateDTO.getRazon_social());
        proveedor.setDireccion(proveedorCreateDTO.getDireccion());
        return proveedorRepository.save(proveedor);
    }

    public Proveedor read(Long id){
        return proveedorRepository.findById(id).orElseThrow( ()->new CrudExceptions("Proveedor no encontrado con id: "+id) );
    }

    public Proveedor update(Long id, ProveedorUpdateDTO proveedorUpdateDTO){
        Optional<Proveedor> existeProveedor = proveedorRepository.findById(id);
        if(existeProveedor.isPresent()){
            Proveedor proveedorUpdate = existeProveedor.get();
            proveedorUpdate.setDireccion(proveedorUpdateDTO.getDireccion());
            proveedorUpdate.setEmail(proveedorUpdateDTO.getEmail());
            proveedorUpdate.setRazon_social(proveedorUpdateDTO.getRazon_social());
            proveedorUpdate.setNombre(proveedorUpdateDTO.getNombre());
            proveedorUpdate.setNit(proveedorUpdateDTO.getNit());
            proveedorUpdate.setTelefono(proveedorUpdateDTO.getTelefono());
            return proveedorRepository.save(proveedorUpdate);
        }else{
            throw new CrudExceptions("El proveedor con id: "+id+", no fue encontrado.");
        }
    }

    public void delete(Long id){
        //Delete físico
        /*if ( !proveedorRepository.existsById(id) ){
            throw new CrudExceptions("No se pudo eliminar el proveedor con id :"+id+".");
        }
        proveedorRepository.deleteById(id);*/

        //Delete lógico
        Proveedor proveedor = proveedorRepository.findById(id).orElseThrow( ()->new CrudExceptions("Usuario con id:"+id+", no encontrado.") );
        proveedor.setActivo(false);
        proveedorRepository.save(proveedor);
    }
}
