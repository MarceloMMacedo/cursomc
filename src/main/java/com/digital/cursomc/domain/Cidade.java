package com.digital.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.digital.cursomc.interfaces.BaseAbstractEntyti;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Cidade extends BaseAbstractEntyti implements Serializable { 
 
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estado;

}
