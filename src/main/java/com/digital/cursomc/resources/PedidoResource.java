package com.digital.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.cursomc.domain.Categoria;
import com.digital.cursomc.domain.Pedido;
import com.digital.cursomc.services.PedidoService;

import javassist.tools.rmi.ObjectNotFoundException;

import com.digital.cursomc.services.*;


@RestController
@RequestMapping(value = "/pedidos")
 
public class PedidoResource {
	@Autowired
	private PedidoService pedidoService;

	 

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(value = "id") Long id) throws ObjectNotFoundException {
		Optional<Pedido> obj = pedidoService.buscar(id);
		return ResponseEntity.ok(obj) ;
	}
}
