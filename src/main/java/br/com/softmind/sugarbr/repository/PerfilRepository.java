package br.com.softmind.sugarbr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softmind.sugarbr.model.Perfil;
import br.com.softmind.sugarbr.model.Usuario;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{
	
	Perfil findByUsuario(Usuario usuario);

}
