package com.digital.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cursomc.domain.Pedido;
import com.digital.cursomc.repositories.PedidoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	public Optional<Pedido> buscar(long id) throws ObjectNotFoundException {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getSimpleName())));
	}
	
	
	public Optional<Pedido> save(Pedido obj_) throws ObjectNotFoundException{
		Pedido  p= pedidoRepository.save(obj_);
		Optional<Pedido> obj =Optional.of(p);
		
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Erro Salvar Pedido")));
	}

}
