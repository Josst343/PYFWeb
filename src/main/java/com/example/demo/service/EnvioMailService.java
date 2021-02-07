package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioMailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void envioMail(String from, String to, String subject, String body) {
		SimpleMailMessage mensaje = new SimpleMailMessage();
		mensaje.setFrom(from);
		mensaje.setTo(to);
		mensaje.setSubject(subject);
		mensaje.setText(body);

		javaMailSender.send(mensaje);

	}

}
