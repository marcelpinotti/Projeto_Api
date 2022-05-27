package com.gft.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "tb_starters")
public class Starter {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome",nullable = false)
	@Size(min = 3, max = 50)
	private String nome;
	
	@Column(name = "cpf", nullable = false)
	@CPF
	private String cpf;
	
	@Column(name = "quatro_letras", nullable = false)
	@Size(min = 4, max = 4)
	private String quatroLetras;
	
	@Column(name = "email", nullable = false)
	@Email
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	
	
	public Starter() {
	}
	
	public Starter(Long id, String nome, String cpf, String quatroLetras, String email, 
			Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.quatroLetras = quatroLetras;
		this.email = email;
		this.categoria = categoria;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getQuatroLetras() {
		return quatroLetras;
	}

	public void setQuatroLetras(String quatroLetras) {
		this.quatroLetras = quatroLetras;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Starter [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", quatroLetras=" + quatroLetras + ", email="
				+ email +", categoria=" + categoria + "]";
	}
		

}
