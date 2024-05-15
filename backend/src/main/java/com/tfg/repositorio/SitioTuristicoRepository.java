package com.tfg.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tfg.modelo.SitioTuristico;

public interface SitioTuristicoRepository extends MongoRepository<SitioTuristico, String> {

	// Método para obtener el máximo valor de 'id'
	@Aggregation("{ '$group': { '_id': null, 'maxId': { '$max': '$_id' } } }")
	Integer findMaxId();

	// Añadir esta anotación con la consulta correcta
	@Query("{ 'usuarioId': ?0 }")
	List<SitioTuristico> findByUsuarioId(String idUsuario);

}
