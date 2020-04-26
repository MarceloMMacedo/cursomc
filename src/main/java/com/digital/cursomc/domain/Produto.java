package com.digital.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;
	
	private double preco;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
	joinColumns = @JoinColumn(name="produto_id"),
	inverseJoinColumns = @JoinColumn(name="categotia_id"))
	private List<Categoria> categorias=new ArrayList<>();

	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

	
	
}
