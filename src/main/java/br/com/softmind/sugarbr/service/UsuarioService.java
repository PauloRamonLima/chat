package br.com.softmind.sugarbr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softmind.sugarbr.model.Usuario;
import br.com.softmind.sugarbr.repository.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario buscarPorId(Long id) throws ObjectNotFoundException {
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		if (usuario == null) {
			throw new ObjectNotFoundException("Objeto Não Encontrado! id: " + id);
		}
		return usuario;
	}
	
	@Transactional
	public Usuario logar(String login, String senha) {
		Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senha);
		return usuario;
	}
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		usuario.setId(null);
		return usuarioRepository.save(usuario);
	}

	@Transactional
	public Usuario atualizar(Usuario usuario) throws ObjectNotFoundException {
		buscarPorId(usuario.getId());
		return usuarioRepository.save(usuario);
	}

	@Transactional
	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public Page<Usuario> listarPaginado(Integer pagina, Integer linhasPorPagina, String ordem, String direcao) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordem);  
		return usuarioRepository.findAll(pageRequest);
	}
	
}