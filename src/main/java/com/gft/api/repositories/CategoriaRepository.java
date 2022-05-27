package com.gft.api.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.api.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public Page<Categoria> findAll(Pageable pageable);

}
