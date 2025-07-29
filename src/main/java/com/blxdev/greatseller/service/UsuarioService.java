package com.blxdev.greatseller.service;

import com.blxdev.greatseller.dto.UsuarioCreateDTO;
import com.blxdev.greatseller.dto.UsuarioUpdateDTO;
import com.blxdev.greatseller.exceptions.CrudExceptions;
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

    public List<Usuario> findAllActivos(){
        return usuarioRepository.findAllByActivoTrue();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow( ()->new CrudExceptions("No se encontró un usuario con id: "+id) );
    }

    public Usuario save(UsuarioCreateDTO usuarioCreateDTO){
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioCreateDTO.getNombre());
        usuario.setApellido(usuarioCreateDTO.getApellido());
        usuario.setUsername(usuarioCreateDTO.getUsername());
        usuario.setPassword(usuarioCreateDTO.getPassword());
        usuario.setRol(usuarioCreateDTO.getRol());
        usuario.setDireccion(usuarioCreateDTO.getDireccion());
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, UsuarioUpdateDTO usuarioUpdateDTO){
        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
        if( existeUsuario.isPresent() ){
            Usuario usuarioUpdate = existeUsuario.get();
            usuarioUpdate.setNombre(usuarioUpdateDTO.getNombre());
            usuarioUpdate.setApellido(usuarioUpdateDTO.getApellido());
            usuarioUpdate.setPassword(usuarioUpdateDTO.getPassword());
            usuarioUpdate.setUsername(usuarioUpdateDTO.getUsername());
            usuarioUpdate.setDireccion(usuarioUpdateDTO.getDireccion());
            //usuarioUpdate.setTelefono(usuarioDTO.getTelefono());
            return usuarioRepository.save(usuarioUpdate);
        }else{
            throw new CrudExceptions("Usuario con id:"+id+", no encontrado para modificar!");
        }
    }

    public void delete(Long id){
        if( !usuarioRepository.existsById(id) ){
            throw new CrudExceptions("No se puede eliminar el usuario con id:"+id+", no existe!");
        }
        Usuario usuario = usuarioRepository.findById(id).orElseThrow( ()->new CrudExceptions("No se puede  eliminar el usuario: "+id));
        usuario.setActivo(false);
        usuarioRepository.save(usuario);
    }
}
