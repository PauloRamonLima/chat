package br.com.softmind.sugarbr.resource;

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

import br.com.softmind.sugarbr.model.Endereco;
import br.com.softmind.sugarbr.model.Usuario;
import br.com.softmind.sugarbr.service.EnderecoService;
import br.com.softmind.sugarbr.service.UsuarioService;

@RestController
@RequestMapping("enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody Endereco endereco) {
		endereco = enderecoService.salvar(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Endereco endereco, @PathVariable Long id) {
		endereco.setId(id);
		endereco = enderecoService.atualizar(endereco);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		enderecoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/usuario/{id}", method =  RequestMethod.GET)
	public ResponseEntity<Endereco> buscarEnderecoDeUsuario(@RequestBody Endereco endereco, @PathVariable Long id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		endereco = enderecoService.buscarEnderecoDeUsuario(usuario);
		return ResponseEntity.ok().body(endereco);
	}
}