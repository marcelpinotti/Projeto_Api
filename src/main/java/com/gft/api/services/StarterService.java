package com.gft.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.api.entities.Starter;
import com.gft.api.repositories.StarterRepository;

@Service
public class StarterService {
	
private final StarterRepository starterRepository;
	
	public StarterService(StarterRepository starterRepository) {
		this.starterRepository = starterRepository;
	}
	
	public Starter salvarStarter(Starter starter) {
		return starterRepository.save(starter);
	}
	
	public Starter buscarStarter(Long id) throws Exception {
		Optional<Starter> starterOptional = starterRepository.findById(id);
		return starterOptional.orElseThrow(() -> new Exception("Cliente não encontrado"));	
	}
	
	public Page<Starter> listarStarters(Pageable pageable){
		return starterRepository.findAll(pageable);	
	}
	
	public Starter buscarStartersPorNome(String nome) throws Exception{
		Optional<Starter> starterOptional = starterRepository.findByNome(nome);	
		return starterOptional.orElseThrow(() -> new Exception("Cliente não encontrado"));		
	}
	
	public Page<Starter> listarStartersPorNomeOrdemCrescente(Pageable pageable){
		return starterRepository.findByOrderByNomeAsc(pageable);	
	}
	
	public Page<Starter> listarStartersPorNomeOrdemDecrescente(Pageable pageable){
		return starterRepository.findByOrderByNomeDesc(pageable);	
	}
	
	public Starter atualizarStarter(Long id, Starter starter) throws Exception {
		Starter starterBusca = buscarStarter(id);
		starter.setId(starterBusca.getId());
		starter.setCategoria(starterBusca.getCategoria());
		return starterRepository.save(starter);	
	}

	public void excluirStarter(Long id) throws Exception {
		Starter starter = buscarStarter(id);
		starterRepository.delete(starter);
	}


}
