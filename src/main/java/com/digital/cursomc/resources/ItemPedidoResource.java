package com.digital.cursomc.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.cursomc.domain.ItemPedido;
import com.digital.cursomc.services.ItemPedidoService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping(value = "/itemPedidos")
 
public class ItemPedidoResource {
	@Autowired
	private ItemPedidoService ItemPedidoService;

	@GetMapping("/listar")
	public List<ItemPedido> listar() {

		List<ItemPedido> lista = new ArrayList<>();

		return lista;

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(value = "id") Integer id) throws ObjectNotFoundException {
		Optional<ItemPedido> obj = ItemPedidoService.buscar(id);
		return ResponseEntity.ok(obj) ;
	}
}
