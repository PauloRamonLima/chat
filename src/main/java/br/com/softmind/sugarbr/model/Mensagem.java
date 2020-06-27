package br.com.softmind.sugarbr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t.mensagem")
public class Mensagem implements Serializable {
	
	private static final long serialVersionUID = 6702507866688981134L;
	
	@Id
	@SequenceGenerator(name = "mensagem_GENERATION", sequenceName = "mensagem_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mensagem_GENERATION")
	@Column(name = "mensagem_id")
	private Long id;
	
	@Column(name = "mensagem_valor")
	private String valor;
	
	@Column(name = "mensagem_tipo")
	private String tipo;
	
	@OneToOne()
	private Conversa conversa;
	
	@OneToOne()
	private Usuario usuarioMensagemEnviada;
	
	@OneToOne()
	private Usuario usuarioMensagemRecebida;
	
	@Column(name = "mensagem_date")
	private Date date;

	public Mensagem() {
		
	}
	
	// Getter e Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conversa getConversa() {
		return conversa;
	}

	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}

	public Usuario getUsuarioMensagemEnviada() {
		return usuarioMensagemEnviada;
	}

	public void setUsuarioMensagemEnviada(Usuario usuarioMensagemEnviada) {
		this.usuarioMensagemEnviada = usuarioMensagemEnviada;
	}

	public Usuario getUsuarioMensagemRecebida() {
		return usuarioMensagemRecebida;
	}

	public void setUsuarioMensagemRecebida(Usuario usuarioMensagemRecebida) {
		this.usuarioMensagemRecebida = usuarioMensagemRecebida;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
