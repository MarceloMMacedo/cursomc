package com.digital.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.digital.cursomc.domain.interfaces.BaseAbstractEntyti;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Produto extends BaseAbstractEntyti implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private double preco;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categotia_id"))
	private List<Categoria> categorias = new ArrayList<>();

//	@JsonIgnore
//	@OneToMany(mappedBy = "id.produto") 
//	private Set<ItemPedido> itens = new HashSet<>();
//	@JsonManagedReference
//	@OneToMany(mappedBy = "produto")
//	private List<ItemPedido> itens = new ArrayList<>();

//	@JsonIgnore
//	public List<Pedido> getPedidos() {
//		List<Pedido> lista = new ArrayList<>();
//
//		for (ItemPedido x : itens) {
//			lista.add(x.getPedido());
//
//		}
//		return lista;
//	}
}
