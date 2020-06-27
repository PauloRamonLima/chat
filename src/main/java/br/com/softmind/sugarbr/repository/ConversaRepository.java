package br.com.softmind.sugarbr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softmind.sugarbr.model.Conversa;

@Repository
public interface ConversaRepository extends JpaRepository<Conversa, Long>{

}
