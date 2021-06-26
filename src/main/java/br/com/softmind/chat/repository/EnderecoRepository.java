package br.com.softmind.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softmind.chat.model.Endereco;
import br.com.softmind.chat.model.Usuario;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	public Endereco findByUsuario(Usuario usuario);
}
