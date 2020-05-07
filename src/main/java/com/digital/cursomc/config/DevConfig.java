package com.digital.cursomc.config;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.support.ServletContextResource;

import com.digital.cursomc.services.DBService;
import com.digital.cursomc.services.EmailService;
import com.digital.cursomc.services.SmtpEmailService;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.PredefinedAcl;
import com.google.common.io.Files;

/* capturar uma chave de um arquibo properties comparar e executar uma operação*/

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
//
//	@Autowired
//	private ServletContext servletContext;

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

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

	@Value("${spring.cloud.gcp.credentials.location}")
	private String credencial;
	
	@Value("${spring.cloud.gcp.config_projectId}")
	private String projectId;

	@Bean
	public Storage storage() {

		try {
			File ins = ResourceUtils.getFile(credencial);			
			
			InputStream in = new FileInputStream(ins);
			
			Credentials credential = GoogleCredentials.fromStream(in);
			
			Storage storage = StorageOptions.newBuilder().setCredentials(credential).setProjectId(projectId)
					.build().getService();

			 return storage;
			 
		} catch (IllegalStateException | IOException e) {
		}
		return StorageOptions.getDefaultInstance().getService();

	}
}
