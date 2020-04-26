package com.digital.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PagamentoComBoleto extends Pagamento  implements Serializable { 
 
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.TIMESTAMP)
	 private Date datavencimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	 private Date datapagamento;
	 
	 
	

}
