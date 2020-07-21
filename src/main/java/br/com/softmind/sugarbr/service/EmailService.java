package br.com.softmind.sugarbr.service;

import org.springframework.mail.SimpleMailMessage;

import br.com.softmind.sugarbr.model.Usuario;

public interface EmailService {
	
	void confirmacaoConta(Usuario usuario);
	void enviarEmail(SimpleMailMessage msg);
}
