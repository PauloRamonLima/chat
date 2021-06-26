package br.com.softmind.chat.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import br.com.softmind.chat.model.Usuario;

public interface EmailService {
	
	void confirmacaoConta(Usuario usuario);
	
	void enviarEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Usuario usuario);
	
	void sendHtmlEmail(MimeMessage msg);
	
}
