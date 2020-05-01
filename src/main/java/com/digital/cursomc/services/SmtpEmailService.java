package com.digital.cursomc.services;

import java.util.HashMap;

import javax.mail.internet.MimeMessage;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
 
	

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

//	@Value("${default.email.hostName}")
//	private String hostName;
//
//	@Value("${default.email.port}")
//	private String smtpPort;
//
//	@Value("${default.email.authentication}")
//	private String authentication;
//
//	@Value("${default.email.password}")
//	private String password;
//
//	@Value("${default.email.nameRemetente}")
//	private String nameRemetente;
//
//	HtmlEmail email = new HtmlEmail();
//
//	DespachEmail despachEmail = new DespachEmail();

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		mailSender.send(msg);
	}

	@Override
	public void despchaEmail(HashMap<String, String> mapa) {

//		email.setDebug(true);
//
//		email.setCharset("UTF-8");
//		// set port
//		email.setSmtpPort(Integer.valueOf(smtpPort));
//		// check this rules for security
//		email.setStartTLSEnabled(true);
//
//		email.setSSLCheckServerIdentity(true);
//
//		email.setHostName(hostName);// server SMTP for Hotmail, alter other
//
//		email.setAuthentication(authentication, password);
//
//		try {
//			email.setFrom(authentication, nameRemetente);
//
//			email.addTo(mapa.get("to"), mapa.get("nome_to"));
//
//			email.addTo(authentication, nameRemetente);
//
//			email.setHtmlMsg(mapa.get("text"));
//
//			LOG.info("Enviando email...");
//
//			email.send();
////			despachEmail.setEmail(email); //thred Email
////			despachEmail.run();// send the email
//			LOG.info("Email enviado");
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Enviando email htmal...");
		javaMailSender.send(msg);
		LOG.info("Email enviado");

	}
}
