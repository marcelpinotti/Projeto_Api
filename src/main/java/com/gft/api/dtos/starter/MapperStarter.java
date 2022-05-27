package com.gft.api.dtos.starter;

import com.gft.api.dtos.categoria.MapperCategoria;
import com.gft.api.entities.Starter;

public class MapperStarter {
	
	public static Starter fromDto(StarterDTO starterDTO) {
		return new Starter(null,starterDTO.getNome(),starterDTO.getCpf(), starterDTO.getQuatroLetras(), starterDTO.getEmail(),
				MapperCategoria.fromDto(starterDTO.getCategoria()));
	}
	
	public static ConsultaRestricaoStarterDTO fromRestrito(Starter starter) {
		return new ConsultaRestricaoStarterDTO(starter.getNome(), starter.getQuatroLetras(), starter.getEmail(), 
				MapperCategoria.fromEntity(starter.getCategoria()));
	}
	
	public static ConsultaStarterDTO fromEntity(Starter starter) {
		return new ConsultaStarterDTO(starter.getId(), starter.getNome(), starter.getCpf(), starter.getQuatroLetras(), 
				MapperCategoria.fromEntity(starter.getCategoria()), starter.getEmail());
	}
		
}
