package com.digital.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.digital.cursomc.domain.enums.converters.TipoClienteConverter;
import com.digital.cursomc.interfaces.BaseAbstractEntyti;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Cliente extends BaseAbstractEntyti implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	private String email;

	private String cpfOrCnpj;
	
	@Convert(converter = TipoClienteConverter.class)
	private String tipo;
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos=new ArrayList<Endereco>();
	
	
	@ElementCollection
	@CollectionTable(name ="TELEFONE")
	private Set<String> telefones = new HashSet<>();

}
