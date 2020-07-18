package br.com.softmind.sugarbr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.softmind.sugarbr.model.Usuario;
import br.com.softmind.sugarbr.repository.UsuarioRepository;
import br.com.softmind.sugarbr.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException(login);
		}
		return new UserSS(usuario.getId(), usuario.getLogin(), usuario.getSenha(), usuario.getPerfisUsuario());
	}
	
}
