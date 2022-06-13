package com.ramiro.demo.rest;

import com.ramiro.demo.model.Cliente;
import com.ramiro.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/ativos")
    public ResponseEntity<List<Cliente>> listOpen(){
        List<Cliente> list = service.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/inativos")
    public ResponseEntity<List<Cliente>> listClose(){
        List<Cliente> list = service.findAllClose();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll(){
        List<Cliente> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente obj){

        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente obj){
        Cliente newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

}
