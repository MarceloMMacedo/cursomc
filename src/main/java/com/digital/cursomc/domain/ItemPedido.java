package com.digital.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
//@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@EqualsAndHashCode.Include
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Double desconto;
	
	private Integer quantidade;
	
	private Double preco;

	public Produto getProduto() {
		return id.getProduto();
	}

	public Pedido getPedido() {
		return id.getPedido();
	}
}
