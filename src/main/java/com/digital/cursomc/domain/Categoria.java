package com.digital.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.dom4j.tree.BaseElement;

import com.digital.cursomc.interfaces.BaseAbstractEntyti;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Categoria extends BaseAbstractEntyti implements Serializable {

	private static final long serialVersionUID = 1L;

	  
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos=new ArrayList<Produto>();

	
	 
	
	
}
