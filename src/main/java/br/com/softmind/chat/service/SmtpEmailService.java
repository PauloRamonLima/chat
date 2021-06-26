package br.com.softmind.chat.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender sender;
	
	@Autowired
	private JavaMailSender jms;
	
	private static final Logger lOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void enviarEmail(SimpleMailMessage msg) {
		lOG.info("Simulando email");
		sender.send(msg);
		lOG.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		// TODO Auto-generated method stub
		lOG.info("Simulando email");
		jms.send(msg);
		lOG.info("Email enviado");
		
	}

}
