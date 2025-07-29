package com.blxdev.greatseller.service;

import com.blxdev.greatseller.dto.CategoriaDTO;
import com.blxdev.greatseller.exceptions.CrudExceptions;
import com.blxdev.greatseller.model.Categoria;
import com.blxdev.greatseller.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaService( CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAllActivos(){
        return categoriaRepository.findAllByActivoTrue();
    }

    public Categoria save(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setFechaRegistro(categoriaDTO.getFechaRegistro());
        return categoriaRepository.save(categoria);
    }

    public Categoria read(Long id){
        return categoriaRepository.findById(id).orElseThrow(()->new CrudExceptions("No se encontró una categoria para el id:"+id));
    }

    public Categoria update(Long id, CategoriaDTO categoriaDTO){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()){
            Categoria categoriaUpdate = categoria.get();
            categoriaUpdate.setNombre(categoriaDTO.getNombre());
            categoriaUpdate.setActivo(categoriaDTO.getActivo());
            //categoriaUpdate.setFechaRegistro(categoriaDTO.getFechaRegistro());
            return categoriaRepository.save(categoriaUpdate);
        }else {
            throw new CrudExceptions("No se encontro ninguna categoria con id:"+id+", para actualizar");
        }
    }

    public void delete(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()->new CrudExceptions("No se encontro categoria para el id:"+id));
        categoria.setActivo(false);
        categoriaRepository.save(categoria);
    }
}
