package com.digital.cursomc.services;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class DespachEmail implements Runnable {

	private HtmlEmail email = new HtmlEmail();

	public DespachEmail(HtmlEmail email) {
		super();
		this.email = email;
	}

	public DespachEmail() {
		// TODO Auto-generated constructor stub
	}

	public HtmlEmail getEmail() {
		return email;
	}

	public void setEmail(HtmlEmail email) {
		this.email = email;
	}

	@Override
	public void run() {
		try {
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
