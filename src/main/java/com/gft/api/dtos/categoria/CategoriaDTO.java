package com.gft.api.dtos.categoria;

public class CategoriaDTO {
	
	private Long id;
	private String tecnologia;
	private String turma;
	
	public CategoriaDTO() {
	}

	public CategoriaDTO(String tecnologia, String turma) {
		this.tecnologia = tecnologia;
		this.turma = turma;
	}
	
	public CategoriaDTO(Long id, String tecnologia, String turma) {
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

}
