package com.blxdev.greatseller.repository;

import com.blxdev.greatseller.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findAllByActivoTrue();
}
