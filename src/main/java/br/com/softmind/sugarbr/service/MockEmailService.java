package br.com.softmind.sugarbr.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService{

	private static final Logger lOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void enviarEmail(SimpleMailMessage msg) {
		lOG.info("Simulando email");
		lOG.info(msg.toString());
		lOG.info("Email enviado");
		
	}

}
