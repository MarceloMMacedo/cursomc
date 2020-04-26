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

import com.digital.cursomc.domain.Cliente;
import com.digital.cursomc.services.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping(value = "/clientes")
 
public class ClienteResource {
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/listar")
	public List<Cliente> listar() {
		List<Cliente> lista = new ArrayList<>();
		return lista;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(value = "id") long id) throws ObjectNotFoundException {
		Optional<Cliente> obj = clienteService.buscar(id);
		return ResponseEntity.ok(obj) ;
	}
}
