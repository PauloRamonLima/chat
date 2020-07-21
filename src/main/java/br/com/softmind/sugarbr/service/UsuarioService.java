package br.com.softmind.sugarbr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softmind.sugarbr.model.PerfilUsuario;
import br.com.softmind.sugarbr.model.Usuario;
import br.com.softmind.sugarbr.repository.UsuarioRepository;
import br.com.softmind.sugarbr.security.UserSS;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Transactional
	public Usuario buscarPorId(Long id) {
		UserSS user = UsuarioLogadoService.usuarioAutenticado();
		if(user == null || user.hasRole(PerfilUsuario.ADMIN) && !id.equals(user.getId()) ) {
			return null;
		}
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		return usuario;
	}
	
	@Transactional
	public Usuario logar(String login, String senha) {
		Usuario usuario = usuarioRepository.findByLoginAndSenha(login, bCryptPasswordEncoder.encode(senha));
		return usuario;
	}
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		usuario.setId(null);
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		emailService.confirmacaoConta(usuario);
		return usuarioRepository.save(usuario);
	}

	@Transactional
	public Usuario atualizar(Usuario usuario) throws ObjectNotFoundException {
		buscarPorId(usuario.getId());
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario desativar(Usuario usuario) {
		usuario.setAtivo(false);
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