package com.digital.cursomc.domain;

import java.io.Serializable;
import java.util.*; 

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.digital.cursomc.domain.enums.converters.EstadoPagamentoConverter;
import com.digital.cursomc.domain.interfaces.BaseAbstractEntyti;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Pedido extends BaseAbstractEntyti implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;

	@Convert(converter = EstadoPagamentoConverter.class)
	private String estado;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "endereco_de_entregantrega_id")
	private Endereco enderecoEntrega;

	@JsonManagedReference
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens = new ArrayList<>();

	
	
}
