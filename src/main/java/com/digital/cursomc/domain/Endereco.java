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
public class Endereco extends  BaseAbstractEntyti implements Serializable { 
	private static final long serialVersionUID = 1L;

	private String contato;

	private String logradouro;

	private String numero;

	private String complemento;

	private String bairro;

	private String cep;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
 
}
