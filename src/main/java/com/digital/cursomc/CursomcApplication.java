package com.digital.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digital.cursomc.domain.Categoria;
import com.digital.cursomc.domain.Cidade;
import com.digital.cursomc.domain.Cliente;
import com.digital.cursomc.domain.Endereco;
import com.digital.cursomc.domain.Estado;
import com.digital.cursomc.domain.ItemPedido;
import com.digital.cursomc.domain.Pagamento;
import com.digital.cursomc.domain.PagamentoComBoleto;
import com.digital.cursomc.domain.PagamentoComCartao;
import com.digital.cursomc.domain.Pedido;
import com.digital.cursomc.domain.Produto;
import com.digital.cursomc.domain.enums.EstadoPagamento;
import com.digital.cursomc.domain.enums.TipoCliente;
import com.digital.cursomc.repositories.CategoriaRepository;
import com.digital.cursomc.repositories.CidadeRepository;
import com.digital.cursomc.repositories.ClienteRepository;
import com.digital.cursomc.repositories.EnderecoRepository;
import com.digital.cursomc.repositories.EstadoRepository;
import com.digital.cursomc.repositories.ItemPedidoRepository;
import com.digital.cursomc.repositories.PagamentoRepository;
import com.digital.cursomc.repositories.PedidoRepository;
import com.digital.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//
//		
		 
		
	}

}
