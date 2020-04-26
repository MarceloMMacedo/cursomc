package com.digital.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cursomc.domain.ItemPedido;
import com.digital.cursomc.repositories.ItemPedidoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ItemPedidoService {
	@Autowired
	private ItemPedidoRepository repo;

	public Optional<ItemPedido> buscar(long id) throws ObjectNotFoundException {
		Optional<ItemPedido> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ItemPedido.class.getSimpleName())));
	}

}
