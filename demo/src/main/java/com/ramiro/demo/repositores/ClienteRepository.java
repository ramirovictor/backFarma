package com.ramiro.demo.repositores;

import com.ramiro.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

    @Query("SELECT obj FROM Cliente obj WHERE obj.desativar = false")
    List<Cliente> findAllAtivo();

    @Query("SELECT obj FROM Cliente obj WHERE obj.desativar = true")
    List<Cliente> findAllInativo();
}
