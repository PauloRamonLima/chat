package br.com.softmind.sugarbr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softmind.sugarbr.model.Conversa;
import br.com.softmind.sugarbr.model.Usuario;

@Repository
public interface ConversaRepository extends JpaRepository<Conversa, Long>{
	
	public Conversa findByUsuariosAndUsuarios(Usuario usuario, Usuario usuario2);
	
	public List<Conversa> findByUsuarios(Usuario usuario);
}
