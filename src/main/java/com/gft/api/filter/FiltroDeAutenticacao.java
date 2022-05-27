package com.gft.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gft.api.entities.Usuario;
import com.gft.api.services.AutenticacaoService;
import com.gft.api.services.UsuarioService;

public class FiltroDeAutenticacao extends OncePerRequestFilter{
	
	
	private AutenticacaoService autenticacaoService;
	private UsuarioService usuarioService;
	
	public FiltroDeAutenticacao(AutenticacaoService autenticacaoService, UsuarioService usuarioService) {
		this.autenticacaoService = autenticacaoService;
		this.usuarioService = usuarioService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader("Authorization");
		String token = null;
		if(header != null && header.startsWith("Bearer ")) {
			token = header.substring(7, header.length());
		}
		
		if(autenticacaoService.verificaToken(token)) {
			Long idUsuario = autenticacaoService.retornarIdUsuario(token);
			Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
			
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities()));
		}
		filterChain.doFilter(request, response);
	}

}
