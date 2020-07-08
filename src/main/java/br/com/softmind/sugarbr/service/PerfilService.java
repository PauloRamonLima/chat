package br.com.softmind.sugarbr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softmind.sugarbr.model.Perfil;
import br.com.softmind.sugarbr.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
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
	
}
