package br.com.softmind.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softmind.chat.model.Conversa;
import br.com.softmind.chat.model.Usuario;
import br.com.softmind.chat.repository.ConversaRepository;
import br.com.softmind.chat.repository.UsuarioRepository;
import br.com.softmind.chat.security.UserSS;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ConversaService {
	
	@Autowired
	private ConversaRepository conversaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Conversa buscarPorId(Long id) throws ObjectNotFoundException {
		Conversa conversa = conversaRepository.findById(id).orElse(null);
		if (conversa == null) {
			throw new ObjectNotFoundException("Objeto Não Encontrado! id: " + id);
		}
		return conversa;
	}
	
	@Transactional
	public Conversa salvar(Conversa conversa) {
		conversa.setId(null);
		return conversaRepository.save(conversa);
	}
	
	@Transactional
	public Conversa atualizar(Conversa conversa) throws ObjectNotFoundException {
		buscarPorId(conversa.getId());
		return conversaRepository.save(conversa);
	}
	
	@Transactional
	public void deletar(Long id) {
		conversaRepository.deleteById(id);
	}
	
	@Transactional
	public Conversa buscarConversaEntreUsuarios(Long id, Long id2) {
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		Usuario usuario2 = usuarioRepository.findById(id).orElse(null);
		return conversaRepository.findByUsuariosAndUsuarios(usuario, usuario2);
	}
	
	@Transactional
	public List<Conversa> buscarConversasDeUsuario(){
		UserSS user = UsuarioLogadoService.usuarioAutenticado();
		if(user == null) {
			return null;
		}
		Usuario usuario = usuarioRepository.findById(user.getId()).orElse(null);
		return conversaRepository.findByUsuarios(usuario);
	}
	
}