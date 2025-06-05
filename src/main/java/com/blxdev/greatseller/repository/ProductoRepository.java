package com.blxdev.greatseller.repository;

import com.blxdev.greatseller.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
