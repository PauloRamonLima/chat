package br.com.softmind.sugarbr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softmind.sugarbr.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
