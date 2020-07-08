package br.com.softmind.sugarbr.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.softmind.sugarbr.model.Conversa;
import br.com.softmind.sugarbr.service.ConversaService;

@RestController
@RequestMapping("conversas")
public class ConversaResource {
	
	@Autowired
	private ConversaService conversaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody Conversa conversa) {
		conversa = conversaService.salvar(conversa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(conversa.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/{id2}", method = RequestMethod.GET)
	public ResponseEntity<Conversa> buscarConversaEntreUsuarios(@PathVariable Long id, @PathVariable Long id2) {
		Conversa conversa = conversaService.buscarConversaEntreUsuarios(id, id2);
		return ResponseEntity.ok().body(conversa);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		conversaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Conversa>> buscarTodasAsConversasDeUmUsuario(@PathVariable Long id){
		List<Conversa> conversasUsuario = conversaService.buscarConversasDeUsuario(id);
		return ResponseEntity.ok().body(conversasUsuario);	
	}
	
}