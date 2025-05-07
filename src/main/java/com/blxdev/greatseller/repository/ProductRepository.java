package com.blxdev.greatseller.repository;

import com.blxdev.greatseller.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
