package br.com.softmind.chat.model;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t.perfil")
public class Perfil implements Serializable {
	
	private static final long serialVersionUID = -7279231133171111599L;
	
	@Id
	@SequenceGenerator(name = "perfil_GENERATION", sequenceName = "perfil_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_GENERATION")
	@Column(name = "perfil_id")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@Column(name = "perfil_fotos")
	@ElementCollection(targetClass = File.class)
	private List<File> fotos;
	
	@Column(name = "perfil_descricao")
	private String descricao;
	
	@Column(name = "perfil_corpo")
	private String tipoCorpo;
	
	@Column(name = "perfil_filhos")
	private String filhos;
	
	@Column(name = "perfil_cabelo")
	private String cabelo;
	
	@Column(name = "perfil_olhos")
	private String olhos;
	
	@Column(name = "perfil_raca")
	private String raca;

	
	public Perfil() {
		
	}
	
	//Getters e Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<File> getFotos() {
		return fotos;
	}

	public void setFotos(List<File> fotos) {
		this.fotos = fotos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoCorpo() {
		return tipoCorpo;
	}

	public void setTipoCorpo(String tipoCorpo) {
		this.tipoCorpo = tipoCorpo;
	}

	public String getFilhos() {
		return filhos;
	}

	public void setFilhos(String filhos) {
		this.filhos = filhos;
	}

	public String getCabelo() {
		return cabelo;
	}

	public void setCabelo(String cabelo) {
		this.cabelo = cabelo;
	}

	public String getOlhos() {
		return olhos;
	}

	public void setOlhos(String olhos) {
		this.olhos = olhos;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
}
