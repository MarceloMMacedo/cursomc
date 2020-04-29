package com.digital.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digital.cursomc.domain.Cliente;
import com.digital.cursomc.domain.ItemPedido;
import com.digital.cursomc.domain.PagamentoComBoleto;
import com.digital.cursomc.domain.Pedido;
import com.digital.cursomc.domain.enums.EstadoPagamento;
import com.digital.cursomc.repositories.ClienteRepository;
import com.digital.cursomc.repositories.ItemPedidoRepository;
import com.digital.cursomc.repositories.PagamentoRepository;
import com.digital.cursomc.repositories.PedidoRepository;
import com.digital.cursomc.repositories.ProdutoRepository;
import com.digital.cursomc.services.exceptions.AuthorizationException;
import com.digital.cursomc.services.exceptions.ObjectNotFoundException;
 

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
//	@Autowired
//	private EmailService emailService;
	
	public Pedido find(Integer id) {
		Pedido obj = repo.findById(id).get();
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteRepository.findById(obj.getCliente().getId()).get());
		obj.getPagamento().setEstado(EstadoPagamento.PENEDETE.getDescricao());
		obj.getPagamento().setPedido(obj);
		
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoRepository.findById(ip.getProduto().getId()).get());
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		//repo.save(obj);
//		emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}
	
	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		UserSS user = UserService.authenticated();
//		if (user == null) {
//			throw new AuthorizationException("Acesso negado");
//		}
		PageRequest pageRequest =   PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
 		Cliente cliente = null  ;//clienteRepository.findById(user.getId());
		return repo.findByCliente(cliente, pageRequest);
	}
}

