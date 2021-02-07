package com.example.demo.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.demo.model.Mail;
@Service("mailService")
public class MailServiceImpl implements MailService {
	@Value("${spring.mail.username}")
	private String from;
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
    private TemplateEngine templateEngine;
	@Override
	public Mail sendSimpleMail(Mail mail) {
	

	
		return mail;
	}

	@Override
	public Mail sendHtmlMaill(Mail mail) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setFrom(from);
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());

			Context context = new Context();
			Map<String, Object> datos = new HashMap<String,Object>();
			datos.put("datos", datos);
			context.setVariables(datos);
			String content = templateEngine.process("mail/email",context);
			helper.setText(content,true);
			ClassLoader classLoader = getClass().getClassLoader();
			File pictureFile = new File(classLoader.getResource("imagen/mariposa.png").getFile());
			
			helper.addInline("mariposa.png", pictureFile);
			
			
			
			javaMailSender.send(message);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mail;
	}

	@Override
	public Mail sendAttachMail(Mail mail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
