package com.digital.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cursomc.domain.Categoria;
import com.digital.cursomc.domain.Produto;
import com.digital.cursomc.repositories.ProdutoRespository;
 

 
@Service
public class ProdutoService {
	@Autowired
	private ProdutoRespository produtoRespository;
	
	public Produto buscar(long id) {
		Produto produto=produtoRespository.findById(id);
		return produto;
	}
}
