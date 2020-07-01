package br.com.softmind.sugarbr.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.softmind.sugarbr.model.Conversa;
import br.com.softmind.sugarbr.model.Mensagem;
import br.com.softmind.sugarbr.service.ConversaService;
import br.com.softmind.sugarbr.service.MensagemService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("mensagem")
public class MensagemResource {
	
	@Autowired
	private MensagemService mensagemService;
	
	@Autowired
	private ConversaService conversaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody Mensagem mensagem){
		mensagem = mensagemService.salvar(mensagem);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(mensagem.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		mensagemService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Mensagem mensagem, @PathVariable Long id) throws ObjectNotFoundException{
		mensagem.setId(id);
		mensagem = mensagemService.atualizar(mensagem);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/paginado/{id}", method = RequestMethod.GET)
	public ResponseEntity<Page<Mensagem>> listarMensagensPorConversa(@RequestParam(value = "pagina", defaultValue = "0") Integer pagina
			,@RequestParam(value = "linhasPorPagina", defaultValue = "120") Integer linhasPorPagina
			,@RequestParam(value = "ordem", defaultValue = "id") String ordem
			,@RequestParam(value = "direcao", defaultValue = "DESC") String direcao
			,@PathVariable Long id) throws ObjectNotFoundException{
		
		Conversa conversa = conversaService.buscarPorId(id);
		Page<Mensagem> mensagens = mensagemService.listarMensagensDeConversaPaginado(pagina, linhasPorPagina, ordem, direcao, conversa);
		return ResponseEntity.ok().body(mensagens);
	}
}