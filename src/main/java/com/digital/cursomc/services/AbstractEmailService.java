package com.digital.cursomc.services;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.digital.cursomc.domain.Cliente;
import com.digital.cursomc.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;

	@Value("${default.recipient}")
	private String to;

	private HashMap<String, String> mapa = new HashMap<>();

	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		mapa.put("to", to);
		mapa.put("nome_to", obj.getCliente().getNome());
		mapa.put("subject", "Pedido confirmado! Código: " + obj.getId());
		mapa.put("text", obj.toString());
//		despchaEmail(mapa);

		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(to);
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());

		return sm;
	}

	@Override
	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(cliente, newPass);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(cliente.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}
//	@Override
//	public void sendEmail(SimpleMailMessage msg) {
//		// TODO Auto-generated method stub
//		
//	}
}
