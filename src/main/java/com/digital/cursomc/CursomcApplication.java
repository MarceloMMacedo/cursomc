package com.digital.cursomc;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digital.cursomc.domain.PagamentoComBoleto;
import com.digital.cursomc.domain.Pedido;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		PagamentoComBoleto boleto = null;
//		Pedido pedido = null;
//		pedido.setPagamento(boleto);
//		Date t=((PagamentoComBoleto)pedido.getPagamento()).getDatapagamento();
		
	}

}
