package com.gft.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.api.dtos.token.AutenticacaoDTO;
import com.gft.api.dtos.token.TokenDTO;
import com.gft.api.services.AutenticacaoService;

@RestController
@RequestMapping(value = "api/auth")
public class AutenticacaoController {
	
	private final AutenticacaoService autenticacaoService;
	
	public AutenticacaoController(AutenticacaoService autenticacaoService) {
		this.autenticacaoService = autenticacaoService;
	}

	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoDTO autenticacaoDTo){
		
		try {
			return ResponseEntity.ok(autenticacaoService.autenticar(autenticacaoDTo));
		} catch (AuthenticationException ae) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
