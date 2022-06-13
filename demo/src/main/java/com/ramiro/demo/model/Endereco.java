package com.ramiro.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Endereco implements Serializable {

     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     private String cep;
     private String complemento;
     private String bairro;
     private String cidade;
     private String uf;


}
