package com.digital.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cursomc.domain.Categoria;
import com.digital.cursomc.repositories.CategoriaRepository;
 

 
@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(long id) {
		Categoria categoria=categoriaRepository.findById(id);
		return categoria;
	}
}
