package com.blxdev.greatseller.service;

import com.blxdev.greatseller.exceptions.CrudExceptions;
import com.blxdev.greatseller.model.Usuario;
import com.blxdev.greatseller.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow( ()->new CrudExceptions("No se encontró un usuario con id: "+id) );
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
            throw new CrudExceptions("Usuario con id:"+id+", no encontrado para modificar!");
        }
    }

    public void delete(Long id){
        if( !usuarioRepository.existsById(id) ){
            throw new CrudExceptions("No se puede eliminar el usuario con id:"+id+", no existe!");
        }
        usuarioRepository.deleteById(id);
    }
}
