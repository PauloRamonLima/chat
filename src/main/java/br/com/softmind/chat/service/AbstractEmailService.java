package br.com.softmind.chat.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.com.softmind.chat.model.Usuario;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine te;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void confirmacaoConta(Usuario usuario) {
		SimpleMailMessage sm = prepareSimpleMailMessage(usuario);
		enviarEmail(sm);
		
	}

	private SimpleMailMessage prepareSimpleMailMessage(Usuario usuario) {
		
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(usuario.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Confirmação de conta");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("O Sistema já está enviando email kkkk");
		return sm;
	}
	
	protected String htmlFromTemplatePedido(Usuario usuario) {
		Context cont = new Context();
		cont.setVariable("usuario", usuario);
		return te.process("email/confirmacaoConta", cont);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Usuario usuario) {
		try {
			MimeMessage	mm = prepareMimeMessage(usuario);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			confirmacaoConta(usuario);
		}
	}

	protected MimeMessage prepareMimeMessage(Usuario usuario) throws MessagingException {
		
		MimeMessage mime = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mime, true);
		mmh.setTo(usuario.getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Confirmação de conta");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(usuario), true);
		return mime;
	}

}
