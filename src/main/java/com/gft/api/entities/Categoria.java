package com.gft.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tecnologia", nullable = false)
	@Size(min = 3, max = 50)
	private String tecnologia;
	
	@Column(name = "turma", nullable = false)
	@Pattern(regexp = "\\d{1}-\\d{4}", message = "O turma deve seguir esse formato, ex. 0-0000.")
	private String turma;
	
	public Categoria() {
	}

	public Categoria(Long id, String tecnologia, String turma) {
		this.id = id;
		this.tecnologia = tecnologia;
		this.turma = turma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", tecnologia=" + tecnologia + ", turma=" + turma + "]";
	}
	

	
}
