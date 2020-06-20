package br.com.softmind.sugarbr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t.usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = -2164791406577479314L;
	
	private Long id;
	
	private String nome;
	
	private String genero;
	
	private String procuraPor;
	
	private TipoUsuario tipoUsuario;
	
	private Perfil perfil;
	
	private List<Conversa> conversas;

}
