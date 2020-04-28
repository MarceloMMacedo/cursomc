package com.digital.cursomc.dto;

import java.io.Serializable;


import org.hibernate.validator.constraints.*;


import com.digital.cursomc.services.validation.ClienteInsert;

import lombok.Data;
 

@ClienteInsert
@Data
public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	@NotBlank(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;

	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;

	@NotEmpty(message="Preenchimento obrigatório")
	private String cpfOuCnpj;

	private String tipo;
	
//	@NotEmpty(message="Preenchimento obrigatório")
//	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;

	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;

	private String complemento;

	private String bairro;

	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone1;

	private String telefone2;
	
	private String telefone3;

	private Long cidadeId;
	
	 
}
