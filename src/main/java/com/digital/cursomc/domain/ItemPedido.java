package com.digital.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.digital.cursomc.domain.interfaces.BaseAbstractEntyti;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor; 


@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemPedido extends BaseAbstractEntyti  implements Serializable {

	private static final long serialVersionUID = 1L;

//	@JsonIgnore
//	@EmbeddedId
////	@EqualsAndHashCode.Include
//	private ItemPedidoPK id = new ItemPedidoPK();

	private Double desconto;

	private Integer quantidade;

	private Double preco;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

//	
}
