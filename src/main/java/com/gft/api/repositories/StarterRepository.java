package com.gft.api.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.api.entities.Starter;

@Repository
public interface StarterRepository extends JpaRepository<Starter, Long> {
	
	public Page<Starter> findAll(Pageable pageable);
	
	public Page<Starter> findByOrderByNomeAsc(Pageable pageable);
	
	public Page<Starter> findByOrderByNomeDesc(Pageable pageable);
	
	public Optional<Starter> findByNome(String nome);

}
