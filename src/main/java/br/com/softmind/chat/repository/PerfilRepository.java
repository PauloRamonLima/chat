package br.com.softmind.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softmind.chat.model.Perfil;
import br.com.softmind.chat.model.Usuario;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{
	
	Perfil findByUsuario(Usuario usuario);

}
