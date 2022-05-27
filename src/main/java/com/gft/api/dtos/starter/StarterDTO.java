package com.gft.api.dtos.starter;

import com.gft.api.dtos.categoria.CategoriaDTO;

public class StarterDTO {

	private String nome;
	private String cpf;
	private String quatro_letras;
	private String email;
	private CategoriaDTO categoria;
	
	public StarterDTO() {
	}
	
	public StarterDTO(String nome, String cpf, String quatroLetras, CategoriaDTO categoria,
			String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.quatro_letras = quatroLetras;
		this.categoria = categoria;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getQuatroLetras() {
		return quatro_letras;
	}

	public void setQuatroLetras(String quatroLetras) {
		this.quatro_letras = quatroLetras;
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
