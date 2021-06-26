package br.com.softmind.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softmind.chat.model.Endereco;
import br.com.softmind.chat.model.Usuario;
import br.com.softmind.chat.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Transactional
	public Endereco buscarPorId(Long id) {
		Endereco endereco  = enderecoRepository.findById(id).orElse(null);
		return endereco;
	}
	
	@Transactional
	public Endereco salvar(Endereco endereco) {
		endereco.setId(null);
		return enderecoRepository.save(endereco);
	}
	
	@Transactional
	public void deletar(Long id) {
		enderecoRepository.deleteById(id);
	}
	
	@Transactional
	public Endereco atualizar(Endereco endereco) {
		buscarPorId(endereco.getId());
		return enderecoRepository.save(endereco);
	}
	
	@Transactional
	public Endereco buscarEnderecoDeUsuario(Usuario usuario) {
		return enderecoRepository.findByUsuario(usuario);
	}
	
}