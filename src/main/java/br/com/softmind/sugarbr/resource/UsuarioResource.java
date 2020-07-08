package br.com.softmind.sugarbr.resource;

import java.net.URI;
import java.util.List;

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

import br.com.softmind.sugarbr.model.Usuario;
import br.com.softmind.sugarbr.service.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/{login}/{senha}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> logar(@PathVariable String login,@PathVariable String senha) {
		Usuario usuario = usuarioService.logar(login, senha);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody Usuario usuario){
		usuario = usuarioService.salvar(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Usuario usuario, @PathVariable Long id) throws ObjectNotFoundException{
		usuario.setId(id);
		usuario = usuarioService.atualizar(usuario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/desativar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> desativar(@RequestBody Usuario usuario, @PathVariable Long id) {
		usuario = usuarioService.buscarPorId(id);
		usuarioService.desativar(usuario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		usuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> usuarios = usuarioService.listar();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@RequestMapping(value = "/paginado", method = RequestMethod.GET)
	public ResponseEntity<Page<Usuario>> listarPaginado(@RequestParam(value = "pagina", defaultValue = "0") Integer pagina 
			,@RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina
			,@RequestParam(value = "ordem", defaultValue = "id") String ordem
			,@RequestParam(value = "direcao", defaultValue = "ASC") String direcao) {
		
		Page<Usuario> usuarios = usuarioService.listarPaginado(pagina, linhasPorPagina, ordem, direcao);
		return ResponseEntity.ok().body(usuarios);
	}
}
