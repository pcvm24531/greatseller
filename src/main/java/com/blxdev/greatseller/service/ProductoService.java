package com.blxdev.greatseller.service;

import com.blxdev.greatseller.model.Producto;
import com.blxdev.greatseller.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository productRepository){
        this.repository = productRepository;
    }

    public List<Producto> getAll(){
        return repository.findAll();
    }

    public Optional<Producto> getById(Long id){
        return repository.findById(id);
    }

    public Producto save(Producto producto){
        return repository.save(producto);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
