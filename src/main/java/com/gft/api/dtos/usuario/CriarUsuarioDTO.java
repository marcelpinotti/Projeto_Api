package com.gft.api.dtos.usuario;

public class CriarUsuarioDTO {
	
	private String login;
	private String senha;
	private Long perfilId;
	
	public CriarUsuarioDTO() {
	}
	public CriarUsuarioDTO(String login, String senha, Long perfilId) {
		this.login = login;
		this.senha = senha;
		this.perfilId = perfilId;
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
	
	public Long getPerfilId() {
		return perfilId;
	}
	
	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}
}
