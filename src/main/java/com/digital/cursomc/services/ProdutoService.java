package com.digital.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cursomc.domain.Produto;
import com.digital.cursomc.repositories.ProdutoRespository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRespository repo;

	public Optional<Produto> buscar(long id) throws ObjectNotFoundException {
		Optional<Produto> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getSimpleName())));
	}

}
