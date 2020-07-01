package br.com.softmind.sugarbr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softmind.sugarbr.model.Conversa;
import br.com.softmind.sugarbr.model.Mensagem;
import br.com.softmind.sugarbr.repository.MensagemRepository;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Transactional
	public Mensagem salvar(Mensagem mensagem) {
		mensagem.setId(null);
		return mensagemRepository.save(mensagem);
	}
	
	@Transactional
	public void deletar(Long id) {
		mensagemRepository.deleteById(id);
	}
	
	public Page<Mensagem> listarMensagensDeConversaPaginado(Integer pagina, Integer linhasPorPagina, String ordem, String direcao, Conversa conversa) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordem);
		return mensagemRepository.findByConversa(conversa, pageRequest);
	}

	@Transactional
	public Mensagem atualizar(Mensagem mensagem) {
		buscarPorId(mensagem.getId());
		return mensagemRepository.save(mensagem);
	}

	private void buscarPorId(Long id) {
		mensagemRepository.findById(id);
	}
}