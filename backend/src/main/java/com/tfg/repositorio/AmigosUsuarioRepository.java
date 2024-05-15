package com.tfg.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfg.modelo.AmigosUsuario;

public interface AmigosUsuarioRepository extends MongoRepository<AmigosUsuario, String> {
	
	// Método para buscar las preferencias de usuario por usuarioId
    List<AmigosUsuario> findByUsuarioId(String usuarioId);
}
