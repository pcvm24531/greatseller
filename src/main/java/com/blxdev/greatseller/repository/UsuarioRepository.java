package com.blxdev.greatseller.repository;

import com.blxdev.greatseller.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByActivoTrue();
}
