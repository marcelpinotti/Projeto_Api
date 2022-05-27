package com.gft.api.dtos.usuario;


public class ConsultaUsuarioDTO {
	
	private String login;
	private String perfil;
	
	public ConsultaUsuarioDTO() {
	}
	
	public ConsultaUsuarioDTO(String login, String perfil) {
		this.login = login;
		this.perfil = perfil;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setNomePerfil(String perfil) {
		this.perfil = perfil;
	}
	
}
