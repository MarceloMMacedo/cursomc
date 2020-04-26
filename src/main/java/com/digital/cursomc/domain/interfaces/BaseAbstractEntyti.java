package com.digital.cursomc.domain.interfaces;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor; 
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@MappedSuperclass
 
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class BaseAbstractEntyti implements Serializable, BaseEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private String nome;

	 
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
