package com.gft.api.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.gft.api.entities.Usuario;
import com.gft.api.repositories.UsuarioRepository;



@Service
public class UsuarioService implements UserDetailsService{
	
private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario buscarUsuarioPorLogin(String login) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findByLogin(login);
		
		if(optionalUsuario.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado");
		}
		return optionalUsuario.get();		
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		return buscarUsuarioPorLogin(username);
	}

	public Usuario buscarUsuarioPorId(Long idUsuario) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(idUsuario);
		if(optionalUsuario.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado");
		}
		return optionalUsuario.get();
	}
	

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);	
	}
}