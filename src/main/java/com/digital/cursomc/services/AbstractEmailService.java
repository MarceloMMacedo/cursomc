package com.digital.cursomc.services;

import java.util.Date;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.digital.cursomc.domain.Cliente;
import com.digital.cursomc.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;

	@Value("${default.recipient}")
	private String to;

	private HashMap<String, String> mapa = new HashMap<>();

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

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
		sm.setFrom(sender);// remetente
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}

	protected String htmlFromTemplatePedido(Pedido obj) {
		Context context = new Context();
		context.setVariable("pedido", obj);
		return templateEngine.process("email/confirmacaoPedido", context);
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		MimeMessage mm = null;
		try {
			mm = prepareMemilMessageFromPedido(obj);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendHtmlEmail(mm);
	}
//	@Override
//	public void sendEmail(SimpleMailMessage msg) {
//		// TODO Auto-generated method stub
//		
//	}

	protected MimeMessage prepareMemilMessageFromPedido(Pedido obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = null;
		 
			mmh = new MimeMessageHelper(mimeMessage, true);
			mmh.setTo(obj.getCliente().getEmail());
			mmh.setFrom(sender);// remetente
			mmh.setSubject("Pedido confirmado! Código: " + obj.getId());
			mmh.setSentDate(new Date(System.currentTimeMillis()));
			mmh.setText(htmlFromTemplatePedido(obj),true);
		 
		return mmh.getMimeMessage();
	}
}
