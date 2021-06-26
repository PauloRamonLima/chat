package br.com.softmind.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.softmind.chat.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByLoginAndSenha(String login, String senha);
	
	@Transactional(readOnly = true)
	Usuario findByLogin(String login);

}
