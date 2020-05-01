package com.digital.cursomc.resources;

 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital.cursomc.domain.Produto;
import com.digital.cursomc.dto.ProdutoDTO;
import com.digital.cursomc.resources.utils.URL;
import com.digital.cursomc.services.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping(value = "/produtos")
 
public class ProdutoResource {
	@Autowired
	private ProdutoService service;

	 

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(value = "id") Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = service.buscar(id);
		return ResponseEntity.ok(obj) ;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value="nome", defaultValue="") String nome, 
			@RequestParam(value="categorias", defaultValue="") String categorias, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		String nomeDecoded = URL.decodeParam(nome);
		 
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Produto> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}
