package com.digital.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.digital.cursomc.domain.enums.converters.EstadoPagamentoConverter;
import com.digital.cursomc.domain.interfaces.BaseAbstractEntyti;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Pagamento extends BaseAbstractEntyti implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 
	
	@Convert(converter = EstadoPagamentoConverter.class)
	private String estado;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;
	
	
	 
	

}
