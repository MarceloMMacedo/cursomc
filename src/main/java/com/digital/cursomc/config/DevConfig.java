package com.digital.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.digital.cursomc.services.DBService;

/* capturar uma chave de um arquibo properties comparar e executar uma operação*/

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		System.out.println(strategy);
		if (!"create".equals(strategy)) {
			return false;
		} else {

			dbService.instantiateTestDatabase();
			return true;
		}
	}

//	@Bean
//	public EmailService emailService() {
//		return new SmtpEmailService();
//	}
}
