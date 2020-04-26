package com.digital.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.digital.cursomc.domain.interfaces.BaseAbstractEntyti;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PagamentoComCartao extends Pagamento implements Serializable { 
 
	private static final long serialVersionUID = 1L;

	 private  Integer numerodeParcelas; 
	 
	 
	

}
