package com.ramiro.demo.services;

import com.ramiro.demo.model.Cliente;
import com.ramiro.demo.repositores.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
    }

    public List<Cliente> findAllOpen() {
        List<Cliente> list = repository.findAllAtivo();
        return list;
    }

    public List<Cliente> findAllClose() {
        List<Cliente> list = repository.findAllInativo();
        return list;
    }

    public List<Cliente> findAll() {
        List<Cliente> list = repository.findAll();
        return list;
    }

    public Cliente create(Cliente obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Cliente update(Integer id, Cliente obj) {

        Cliente newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setDocumento(obj.getDocumento());
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setTelefone(obj.getTelefone());
        newObj.setEndereco(obj.getEndereco());
        newObj.setDesativar(obj.isDesativar());
        return repository.save(newObj);
    }
}
