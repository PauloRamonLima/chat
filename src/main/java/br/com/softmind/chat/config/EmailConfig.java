package br.com.softmind.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.softmind.chat.service.EmailService;
import br.com.softmind.chat.service.SmtpEmailService;

@Configuration
public class EmailConfig {
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
