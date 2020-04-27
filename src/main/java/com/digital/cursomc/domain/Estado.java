package com.digital.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.digital.cursomc.domain.interfaces.BaseAbstractEntyti;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Estado extends BaseAbstractEntyti implements Serializable {

	private static final long serialVersionUID = 1L;
	
 
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades=new ArrayList<Cidade>();
	

}
