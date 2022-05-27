package com.gft.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.api.dtos.usuario.ConsultaUsuarioDTO;
import com.gft.api.dtos.usuario.CriarUsuarioDTO;
import com.gft.api.dtos.usuario.MapperUsuario;
import com.gft.api.entities.Usuario;
import com.gft.api.services.UsuarioService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("api/usuarios")
@SecurityRequirement(name = "swagger_JWT")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaUsuarioDTO> salvarUsuario(@RequestBody CriarUsuarioDTO usuarioDTO){	
			Usuario usuario = usuarioService.salvarUsuario(MapperUsuario.fromDTO(usuarioDTO));
			return ResponseEntity.ok(MapperUsuario.fromEntity(usuario));
	}	
}
