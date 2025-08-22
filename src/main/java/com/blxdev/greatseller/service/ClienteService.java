package com.blxdev.greatseller.service;

import com.blxdev.greatseller.dto.ClienteCreateDTO;
import com.blxdev.greatseller.dto.ClienteUpdateDTO;
import com.blxdev.greatseller.exceptions.CrudExceptions;
import com.blxdev.greatseller.model.Cliente;
import com.blxdev.greatseller.model.Usuario;
import com.blxdev.greatseller.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAllActivos(){
        return clienteRepository.findAllByActivoTrue();
    }

    public Cliente create(ClienteCreateDTO clienteCreateDTO){
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteCreateDTO.getNombre());
        cliente.setDireccion(clienteCreateDTO.getDireccion());
        cliente.setNit_ci(clienteCreateDTO.getNit_ci());
        cliente.setTelefono(clienteCreateDTO.getTelefono());
        cliente.setEmail(clienteCreateDTO.getEmail());
        cliente.setActivo(clienteCreateDTO.getActivo());
        return clienteRepository.save(cliente);
    }

    public Cliente read (Long id){
        return clienteRepository.findById(id).orElseThrow(
                ()->new CrudExceptions("No se encontró el cliente con id: "+id)
        );
    }

    public Cliente update(ClienteUpdateDTO clienteUpdateDTO, Long id){
        System.out.println(clienteUpdateDTO);
        Optional<Cliente> existeCliente = clienteRepository.findById(id);
        if ( existeCliente.isPresent() ){
            Cliente actualizarCliente = existeCliente.get();
            actualizarCliente.setActivo(clienteUpdateDTO.getActivo());
            actualizarCliente.setDireccion(clienteUpdateDTO.getDireccion());
            actualizarCliente.setEmail(clienteUpdateDTO.getEmail());
            actualizarCliente.setNit_ci(clienteUpdateDTO.getNit_ci());
            actualizarCliente.setTelefono(clienteUpdateDTO.getTelefono());
            actualizarCliente.setNombre(clienteUpdateDTO.getNombre());
            return clienteRepository.save(actualizarCliente);
        }else{
            throw new CrudExceptions("No se pudo encontrar el cliente: "+id);
        }
    }

    public void delete(Long id){
        Cliente findCliente = clienteRepository.findById(id).orElseThrow(
                ()->new CrudExceptions("No se encontro el cliente.")
        );
        findCliente.setActivo(false);
        clienteRepository.save(findCliente);
    }
}
