package com.blxdev.greatseller.controller;

import com.blxdev.greatseller.model.Product;
import com.blxdev.greatseller.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> list(){
        return productRepository.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product read(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productRepository.deleteById(id);
    }
}
