package br.com.softmind.chat.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.softmind.chat.model.Perfil;
import br.com.softmind.chat.service.PerfilService;

@RestController
@RequestMapping("perfil")
public class PerfilResource {
	
	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody Perfil perfil) {
		perfil = perfilService.salvar(perfil);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(perfil.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		perfilService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Perfil perfil, @PathVariable Long id) {
		perfil.setId(id);
		perfil = perfilService.atualizar(perfil);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/usuario/{id}", method  = RequestMethod.GET)
	public ResponseEntity<Perfil> buscarPerfilUsuario(@PathVariable Long id){
		Perfil perfil = perfilService.buscarPerfilDeUsuario(id);
		return ResponseEntity.ok().body(perfil);
	}
	
}