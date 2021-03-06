package br.com.softmind.chat.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "t.usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2164791406577479314L;

	@Id
	@SequenceGenerator(name = "usuario_GENERATION", sequenceName = "usuario_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_GENERATION")
	@Column(name = "usuario_id")
	private Long id;

	@Column(name = "usuario_nome")
	@NotEmpty(message = "Campo Obrigatório")
	@Length(min = 5, max = 100, message = "Campo deve ter entre 5 e 100 caracteres")
	private String nome;
	
	@Column(name = "usuario_login")
	private String login;
	
	@Column(name = "usuario_senha")
	private String senha;

	@Column(name = "usuario_idade")
	private Integer idade;
	
	@Column(name = "usuario_email")
	private String email;

	@Column(name = "usuario_genero")
	private String genero;

	@Column(name = "usuario_procuroPor")
	private String procuraPor;
	
	@Column(name = "usuario_ativo")
	private Boolean ativo;

	@Column(name = "usuario_tipo")
	private TipoUsuario tipoUsuario;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_perfil", joinColumns = {
			@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id") }, inverseJoinColumns = {
					@JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id") })
	private Perfil perfil;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Conversa> conversas;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_conversas", joinColumns = {
			@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id") }, inverseJoinColumns = {
					@JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id") })
	private Endereco endereco;
	
	@Column(name = "perfil_usuario")
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<PerfilUsuario> perfisUsuario;
	

	public Usuario() {
		//addPerfil(PerfilUsuario.COMUM);
	}
	
	//Getters And Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getProcuraPor() {
		return procuraPor;
	}

	public void setProcuraPor(String procuraPor) {
		this.procuraPor = procuraPor;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Conversa> getConversas() {
		return conversas;
	}

	public void setConversas(List<Conversa> conversas) {
		this.conversas = conversas;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<PerfilUsuario> getPerfisUsuario() {
		return perfisUsuario;
	}

	public void setPerfilUsuario(Set<PerfilUsuario> perfisUsuario) {
		this.perfisUsuario = perfisUsuario;
	}
	
	public void addPerfil(PerfilUsuario perfil) {
		perfisUsuario.add(perfil);
	}

	public void setPerfisUsuario(Set<PerfilUsuario> perfisUsuario) {
		this.perfisUsuario = perfisUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
