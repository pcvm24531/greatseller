package com.blxdev.greatseller.service;

import com.blxdev.greatseller.model.Usuario;
import com.blxdev.greatseller.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuario){
        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
        if( existeUsuario.isPresent() ){
            Usuario usuarioUpdate = existeUsuario.get();
            usuarioUpdate.setNombre(usuario.getNombre());
            usuarioUpdate.setApellido(usuario.getApellido());
            usuarioUpdate.setPassword(usuario.getPassword());
            usuarioUpdate.setUsername(usuario.getUsername());
            usuarioUpdate.setDireccion(usuario.getDireccion());
            usuarioUpdate.setTelefono(usuario.getTelefono());
            return usuarioRepository.save(usuarioUpdate);
        }else{
            throw new RuntimeException("Usuario con id:"+id+", no encontrado");
        }
    }
}
