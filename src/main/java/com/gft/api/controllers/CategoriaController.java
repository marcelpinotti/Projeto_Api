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

import com.gft.api.dtos.categoria.CategoriaDTO;
import com.gft.api.dtos.categoria.MapperCategoria;
import com.gft.api.entities.Categoria;
import com.gft.api.services.CategoriaService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;



@RestController
@RequestMapping(value = "/api/categorias")
@SecurityRequirement(name = "swagger_JWT")
public class CategoriaController {
	
private final  CategoriaService categoriaService;
	
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<CategoriaDTO> salvarCategoria(@RequestBody CategoriaDTO categoriaDTO){
		Categoria  categoria = categoriaService.salvarCategoria(MapperCategoria.fromDto(categoriaDTO));
		return ResponseEntity.ok(MapperCategoria.fromEntity(categoria));
	}
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Page<CategoriaDTO>> buscarTodosAsCategorias(@PageableDefault @ParameterObject Pageable pageable){
		return ResponseEntity.ok(categoriaService.listarCategoria(pageable).map(MapperCategoria::fromEntity));			
	}
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Long id) throws Exception{
		try {
			Categoria categoria = categoriaService.buscarCategoria(id);
			return ResponseEntity.ok(MapperCategoria.fromEntity(categoria));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
			
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<CategoriaDTO> alterarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) throws Exception{
		try {
			Categoria categoria = categoriaService.atualizarCategoria(id, MapperCategoria.fromDto(categoriaDTO));
			return ResponseEntity.ok(MapperCategoria.fromEntity(categoria));
		}catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<CategoriaDTO> excluirCategoria(@PathVariable Long id) throws Exception{
		try {
			categoriaService.excluirCategoria(id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
