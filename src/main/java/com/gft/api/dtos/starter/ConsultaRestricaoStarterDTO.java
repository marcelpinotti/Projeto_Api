package com.gft.api.dtos.starter;

import com.gft.api.dtos.categoria.CategoriaDTO;

public class ConsultaRestricaoStarterDTO {
	
	private String nome;
	private String quatro_letras;
	private String email;
	private CategoriaDTO categoria; 
	
	
	public ConsultaRestricaoStarterDTO() {	
	}
	
	public ConsultaRestricaoStarterDTO(String nome, String quatro_letras, String email, CategoriaDTO categoria) {
		this.nome = nome;
		this.quatro_letras = quatro_letras;
		this.email = email;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuatro_letras() {
		return quatro_letras;
	}

	public void setQuatro_letras(String quatro_letras) {
		this.quatro_letras = quatro_letras;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
	
}
