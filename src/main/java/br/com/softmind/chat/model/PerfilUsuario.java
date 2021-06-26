package br.com.softmind.chat.model;

public enum PerfilUsuario{
	
	GOLD(1, "ROLE_GOLD"),
	COMUM(2, "ROLE_COMUM"),
	ADMIN(3, "ROLE_ADMIN");
	
	private int id;
	private String descricao;
	
	private PerfilUsuario(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	private PerfilUsuario() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
