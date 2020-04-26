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

import com.digital.cursomc.domain.Categoria;
import com.digital.cursomc.services.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping(value = "/categorias")
 
public class CategoriaResource {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/listar")
	public List<Categoria> listar() {

		List<Categoria> lista = new ArrayList<>();

		return lista;

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(value = "id") long id) throws ObjectNotFoundException {
		Optional<Categoria> obj = categoriaService.buscar(id);
		return ResponseEntity.ok(obj) ;
	}
}
