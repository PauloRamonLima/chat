package br.com.softmind.sugarbr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t.conversa")
public class Conversa implements Serializable{

	private static final long serialVersionUID = -7116837607156547710L;
	
	@Id
	@SequenceGenerator(name = "conversa_GENERATION", sequenceName = "conversa_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conversa_GENERATION")
	@Column(name = "conversa_id")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private List<Mensagem> mensagens;
	
	@ManyToMany
	private List<Usuario> usuario;

	//Getters e Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
}
