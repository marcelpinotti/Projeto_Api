package com.gft.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.api.entities.Categoria;
import com.gft.api.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	
private final CategoriaRepository categoriaRepository;
	
	public CategoriaService (CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public Categoria salvarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria buscarCategoria(Long id) throws Exception {
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
		return categoriaOptional.orElseThrow(() -> new Exception("Categoria não encontrado"));	
	}
	
	public Page<Categoria> listarCategoria(Pageable pageable){
		return categoriaRepository.findAll(pageable);	
	}
	
	public Categoria atualizarCategoria(Long id, Categoria categoria) throws Exception {
		Categoria categoriaBusca = buscarCategoria(id);
		categoria.setId(categoriaBusca.getId());
		return categoriaRepository.save(categoria);	
	}

	public void excluirCategoria(Long id) throws Exception {
		Categoria categoria = buscarCategoria(id);
		categoriaRepository.delete(categoria);
	}



}
