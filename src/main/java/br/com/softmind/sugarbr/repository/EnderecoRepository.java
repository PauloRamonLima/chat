package br.com.softmind.sugarbr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softmind.sugarbr.model.Endereco;
import br.com.softmind.sugarbr.model.Usuario;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	public Endereco findByUsuario(Usuario usuario);
}
