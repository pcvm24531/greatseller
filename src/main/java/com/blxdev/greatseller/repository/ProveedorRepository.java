package com.blxdev.greatseller.repository;

import com.blxdev.greatseller.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    List<Proveedor> findAllByActivoTrue();
}
