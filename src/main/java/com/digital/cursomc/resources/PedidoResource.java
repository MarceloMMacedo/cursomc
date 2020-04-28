package com.digital.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.cursomc.domain.PagamentoComCartao;
import com.digital.cursomc.domain.Pedido;
import com.digital.cursomc.domain.enums.EstadoPagamento;
import com.digital.cursomc.repositories.ClienteRepository;
import com.digital.cursomc.repositories.PagamentoRepository;
import com.digital.cursomc.services.PedidoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/pedidos")

public class PedidoResource {
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(value = "id") Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = pedidoService.buscar(id);
		
//		Pedido p = new Pedido();
//		PagamentoComCartao boleto = new PagamentoComCartao();
//		boleto.setNumerodeParcelas(6);
//		boleto.setEstado(EstadoPagamento.CANCELADO.getDescricao());
//		boleto.setPedido(p);
//		p.setPagamento(boleto);
//		
//		p.setCliente(clienteRepository.findById(1L).get());
//		
//		p.setEnderecoEntrega(p.getCliente().getEnderecos().get(0));
//
//		pedidoService.save( p);
		return ResponseEntity.ok(obj);
	}
}
