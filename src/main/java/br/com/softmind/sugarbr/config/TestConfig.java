package br.com.softmind.sugarbr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.softmind.sugarbr.service.EmailService;
import br.com.softmind.sugarbr.service.MockEmailService;

@Configuration
public class TestConfig {
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
