package com.digital.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cursomc.domain.Pagamento;
import com.digital.cursomc.repositories.PagamentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PagamentoService {
	@Autowired
	private PagamentoRepository repo;

	public Optional<Pagamento> buscar(Integer id) throws ObjectNotFoundException {
		Optional<Pagamento> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pagamento.class.getSimpleName())));
	}

}
