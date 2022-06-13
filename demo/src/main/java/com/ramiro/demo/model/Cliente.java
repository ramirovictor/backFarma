package com.ramiro.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	private String nome;

	private String documento;
//	private Documento documento;

	private String email;

	private String telefone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Endereco endereco;

	private boolean desativar = false;
}
