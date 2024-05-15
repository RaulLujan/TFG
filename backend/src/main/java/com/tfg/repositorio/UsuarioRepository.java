package com.tfg.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tfg.modelo.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
    // Método para encontrar un usuario por correo o nombre de usuario
    // usando una consulta personalizada con @Query
    @Query("{$or: [{'correo': ?0}, {'nombreUsuario': ?1}]}")
    Usuario findByCorreoOrNombreUsuario(String correo, String nombreUsuario);
    
    // Método para obtener el máximo valor de 'id'
    @Aggregation("{ '$group': { '_id': null, 'maxId': { '$max': '$_id' } } }")
    Integer findMaxId();
    
 // Método para buscar un usuario por su ID
    Optional<Usuario> findById(String id);
}
