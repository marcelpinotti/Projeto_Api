package com.gft.api.dtos.categoria;

import com.gft.api.entities.Categoria;

public class MapperCategoria {
	
	public static Categoria fromDto(CategoriaDTO CategoriaDTO) {
		return new Categoria(null, CategoriaDTO.getTecnologia(), CategoriaDTO.getTurma());
	}
	
	public static CategoriaDTO fromEntity(Categoria categoria) {
		return new CategoriaDTO(categoria.getId(), categoria.getTecnologia(), categoria.getTurma());
	}
}
