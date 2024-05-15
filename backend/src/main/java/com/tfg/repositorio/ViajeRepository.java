package com.tfg.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.tfg.modelo.Viaje;

public interface ViajeRepository extends MongoRepository<Viaje, String> {
	
   
	// Método para buscar Viajes
    Viaje findById(Integer id);
    
}
