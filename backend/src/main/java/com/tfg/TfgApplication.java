package com.tfg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tfg.control.Control;
import com.tfg.modelo.AmigosUsuario;
import com.tfg.modelo.Busqueda;
import com.tfg.modelo.ParticipantesViaje;
import com.tfg.modelo.PreferenciasUsuario;
import com.tfg.modelo.Usuario;
import com.tfg.modelo.Viaje;

@SpringBootApplication
public class TfgApplication implements CommandLineRunner {
	@Autowired
	private Control control;

	public static void main(String[] args) {
		SpringApplication.run(TfgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}