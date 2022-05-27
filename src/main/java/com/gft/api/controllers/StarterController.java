package com.gft.api.controllers;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.api.dtos.starter.ConsultaRestricaoStarterDTO;
import com.gft.api.dtos.starter.ConsultaStarterDTO;
import com.gft.api.dtos.starter.MapperStarter;
import com.gft.api.dtos.starter.StarterDTO;
import com.gft.api.entities.Starter;
import com.gft.api.services.StarterService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/api/starters")
@SecurityRequirement(name = "swagger_JWT")
public class StarterController {
	
	private final  StarterService starterService;
	
	public StarterController(StarterService starterService) {
		this.starterService = starterService;
	}

	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaStarterDTO> salvarStarter(@RequestBody StarterDTO starterDTO){
		Starter starter = starterService.salvarStarter(MapperStarter.fromDto(starterDTO));
		return ResponseEntity.ok(MapperStarter.fromEntity(starter));
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Page<ConsultaStarterDTO>> buscarTodosOsStarters(@PageableDefault @ParameterObject Pageable pageable){
		return ResponseEntity.ok(starterService.listarStarters(pageable).map(MapperStarter::fromEntity));			
	}
	
	@GetMapping("/busca_restrita")
	@PreAuthorize("hasAnyAuthority('Admin','Usuario')")
	public ResponseEntity<Page<ConsultaRestricaoStarterDTO>> buscarTodosOsStartersComEntityFiltro(@PageableDefault @ParameterObject Pageable pageable){
		return ResponseEntity.ok(starterService.listarStarters(pageable).map(MapperStarter::fromRestrito));			
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaStarterDTO> buscarStarterPorId(@PathVariable Long id) throws Exception{
		try {
			Starter starter = starterService.buscarStarter(id);
			return ResponseEntity.ok(MapperStarter.fromEntity(starter));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
			
	}
	
	@GetMapping("/asc")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Page<ConsultaRestricaoStarterDTO>> buscarStartersOrdemCrescente(@PageableDefault @ParameterObject Pageable pageable){
		return ResponseEntity.ok(starterService.listarStartersPorNomeOrdemCrescente(pageable).map(MapperStarter::fromRestrito));			
	}
	
	@GetMapping("/desc")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Page<ConsultaRestricaoStarterDTO>> buscarStartersOrdemDecrescente(@PageableDefault @ParameterObject Pageable pageable){
		return ResponseEntity.ok(starterService.listarStartersPorNomeOrdemDecrescente(pageable).map(MapperStarter::fromRestrito));			
	}
	
	@GetMapping("/nome/{nome}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaStarterDTO> buscarStarterPorNome(@PathVariable String nome) throws Exception{
		try {
			Starter starter = starterService.buscarStartersPorNome(nome);
			return ResponseEntity.ok(MapperStarter.fromEntity(starter));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaStarterDTO> alterarStarter(@PathVariable Long id, @RequestBody StarterDTO starterDTO) throws Exception{
		try {
			Starter starter = starterService.atualizarStarter(id, MapperStarter.fromDto(starterDTO));
			return ResponseEntity.ok(MapperStarter.fromEntity(starter));
		}catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<StarterDTO> excluirStarter(@PathVariable Long id) throws Exception{
		try {
			starterService.excluirStarter(id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
