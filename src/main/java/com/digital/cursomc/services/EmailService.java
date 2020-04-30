package com.digital.cursomc.services;

import java.util.HashMap;

import org.springframework.mail.SimpleMailMessage;

import com.digital.cursomc.domain.Cliente;
import com.digital.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void despchaEmail( HashMap<String, String> mapa) ;
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
