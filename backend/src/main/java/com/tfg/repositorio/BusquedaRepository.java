package com.tfg.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfg.modelo.Busqueda;
import com.tfg.modelo.PreferenciasUsuario;

public interface BusquedaRepository extends MongoRepository<Busqueda, String> {
	
	// Método para buscar las busquedas de usuario por usuarioId
    List<Busqueda> findByUsuarioId(String usuarioId);
}
