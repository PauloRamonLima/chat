package br.com.softmind.chat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softmind.chat.model.Conversa;
import br.com.softmind.chat.model.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long>{
	
	public Page<Mensagem> findByConversa(Conversa conversa, Pageable pageable);
}


