package br.com.softmind.sugarbr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t.endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = -2442472125219782764L;
	
	@Id
	@SequenceGenerator(name = "endereco_GENERATION", sequenceName = "endereco_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_GENERATION")
	@Column(name = "endereco_id")
	private Long id;
	
	@OneToOne()
	private Usuario usuario;
	
	@Column(name = "endereco_pais")
	private String pais;
	
	@Column(name = "endereco_estado")
	private String estado;
	
	@Column(name = "endereco_cidade")
	private String cidade;

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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
