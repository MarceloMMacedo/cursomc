package com.digital.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.cursomc.domain.Categoria;
import com.digital.cursomc.domain.Produto;
import com.digital.cursomc.services.ProdutoService;


@RestController
@RequestMapping(value = "/produtos")
 
public class ProdutoResource {
	@Autowired
	private ProdutoService produtoService;

	 

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(value = "id") long id) {
		Optional<Produto> obj = produtoService.buscar(id);
		return ResponseEntity.ok(obj) ;
	}
}
