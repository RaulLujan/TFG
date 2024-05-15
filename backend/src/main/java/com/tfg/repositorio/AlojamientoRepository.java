package com.tfg.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tfg.modelo.Alojamiento;


public interface AlojamientoRepository extends MongoRepository<Alojamiento, String> {
	
    // Método para obtener el máximo valor de 'id'
    @Aggregation("{ '$group': { '_id': null, 'maxId': { '$max': '$_id' } } }")
    Integer findMaxId();
    
	// Añadir esta anotación con la consulta correcta
	@Query("{ 'idUsuario': ?0 }")
    List<Alojamiento>findByIdUsuario(String idUsuario);
}
