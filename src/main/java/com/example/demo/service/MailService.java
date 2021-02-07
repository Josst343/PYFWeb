package com.example.demo.service;

import com.example.demo.model.Mail;

public interface MailService {
	
	
	Mail sendSimpleMail(Mail mail);
	Mail sendHtmlMaill(Mail mail);
	Mail sendAttachMail(Mail mail);


}
