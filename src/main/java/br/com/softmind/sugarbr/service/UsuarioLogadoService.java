package br.com.softmind.sugarbr.service;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.softmind.sugarbr.security.UserSS;

public class UsuarioLogadoService {
	
	public static UserSS usuarioAutenticado() {
		try {	
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch (Exception e) {
			return null;
		}
	}
}
