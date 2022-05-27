package com.gft.api.dtos.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gft.api.entities.Perfil;
import com.gft.api.entities.Usuario;

public class MapperUsuario {
	
	public static Usuario fromDTO(CriarUsuarioDTO usuarioDTO) {
		
		Perfil perfil = new Perfil();
		perfil.setId(usuarioDTO.getPerfilId());
		
		return new Usuario(null, usuarioDTO.getLogin(), new BCryptPasswordEncoder().encode(usuarioDTO.getSenha()), perfil);
		
	}
	
	public static ConsultaUsuarioDTO fromEntity(Usuario usuario) {
		
		return new ConsultaUsuarioDTO(usuario.getLogin(), usuario.getPerfil().getNome());
		
	}

}
