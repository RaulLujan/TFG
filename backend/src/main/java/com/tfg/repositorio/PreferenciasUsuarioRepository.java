package com.tfg.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfg.modelo.PreferenciasUsuario;

public interface PreferenciasUsuarioRepository extends MongoRepository<PreferenciasUsuario, String> {
	
	// Método para buscar las preferencias de usuario por usuarioId
    PreferenciasUsuario findByUsuarioId(String usuarioId);
}
