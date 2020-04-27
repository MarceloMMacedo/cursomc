package com.digital.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Cidade extends BaseAbstractEntyti implements Serializable { 
 
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estado;
	
	 
	@OneToMany(mappedBy = "cidade")
	private List<Endereco> enderecos=new ArrayList<Endereco>();
	

}
