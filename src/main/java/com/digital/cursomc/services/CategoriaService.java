package com.digital.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cursomc.domain.Categoria;
import com.digital.cursomc.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;

	public Optional<Categoria> buscar(long id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getSimpleName())));
	}

}
