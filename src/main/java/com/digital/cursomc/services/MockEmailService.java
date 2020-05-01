package com.digital.cursomc.services;

import java.util.HashMap;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}

	@Override
	public void despchaEmail(HashMap<String, String> mapa) {
		// TODO Auto-generated method stub
		
	}
 

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		// TODO Auto-generated method stub
		
	}
}
