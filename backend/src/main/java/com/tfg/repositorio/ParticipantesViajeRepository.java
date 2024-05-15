package com.tfg.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfg.modelo.ParticipantesViaje;

public interface ParticipantesViajeRepository extends MongoRepository<ParticipantesViaje, String> {
	
	// Método para buscar las preferencias de usuario por usuarioId
	List<ParticipantesViaje> findByUsuarioId(String usuarioId);
    
}
