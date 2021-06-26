package br.com.softmind.chat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softmind.chat.model.Perfil;
import br.com.softmind.chat.model.Usuario;
import br.com.softmind.chat.repository.PerfilRepository;
import br.com.softmind.chat.repository.UsuarioRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private UsuarioRepository usuariorepository;
	
	@Transactional
	public Perfil salvar(Perfil perfil) {
		perfil.setId(null);
		return perfilRepository.save(perfil);
	}
	
	@Transactional
	public void deletar(Long id) {
		perfilRepository.deleteById(id);
	}
	
	@Transactional
	public Perfil atualizar(Perfil perfil) {
		buscarPorId(perfil.getId());
		return perfilRepository.save(perfil);
		
	}
	
	private void buscarPorId(Long id) {
		perfilRepository.findById(id);
	}
	
	@Transactional
	public Perfil buscarPerfilDeUsuario(Long id) {
		Usuario usuario = usuariorepository.findById(id).orElse(null);
		return perfilRepository.findByUsuario(usuario);
	}
}
