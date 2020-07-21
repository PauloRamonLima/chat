package br.com.softmind.sugarbr.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.softmind.sugarbr.model.Usuario;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
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
}
