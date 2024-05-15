package com.tfg.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.control.Control;
import com.tfg.dto.BusquedaAlojaminetoDTO;
import com.tfg.dto.BusquedaSTDTO;
import com.tfg.dto.STAlojamientosDTO;
import com.tfg.dto.UsuarioPerfilDTO;
import com.tfg.exception.ServicioException;
import com.tfg.modelo.Alojamiento;
import com.tfg.modelo.Busqueda;
import com.tfg.modelo.PreferenciasUsuario;
import com.tfg.modelo.SitioTuristico;
import com.tfg.modelo.Usuario;

@RestController
public class Servicio {

	@Autowired
	private Control control;

	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario usuario) {
		Usuario user = control.consultarUserLogin(usuario);
		if (user != null)
			return user;
		else
			throw new ServicioException("Credenciales inválidas");
	}

	@PostMapping("/register")
	public Usuario register(@RequestBody Usuario usuario) {
		if (control.consultarUserLogin(usuario) != null)
			throw new ServicioException("El Usuario ya exite");
		else
			return control.registrarUser(usuario);
	}

	@GetMapping("/perfil")
	public PreferenciasUsuario obtenerPerfil(@RequestParam(name = "idUsuario", required = true) String idUsuario) {
		return control.obtenerPerfil(idUsuario);
	}

	@PutMapping("/perfil")
	public Usuario actulizarPerfil(@RequestBody UsuarioPerfilDTO usuarioPerfilDTO) {
		return control.actualizarPreferenciasUsuario(usuarioPerfilDTO);
	}

	@GetMapping("/listaAmigos")
	public List<Usuario> obtenerListaAmigos(@RequestParam(name = "idUsuario", required = true) String idUsuario) {
		return control.obtenerListaAmigos(idUsuario);
	}

	@GetMapping("/busqueda")
	public List<Busqueda> obtenerBusquedas(@RequestParam(name = "idUsuario", required = true) String idUsuario) {
		return control.obtenerBusquedas(idUsuario);
	}

	@PostMapping("/buscarST")
	public List<SitioTuristico> buscarST(@RequestBody BusquedaSTDTO busqueda) {
		return control.obtenerSitiosTuristicos(busqueda);
	}

	@PostMapping("/guardarST")
	public SitioTuristico guardarST(@RequestBody SitioTuristico sitio) {
		return control.guardarSitiosTuristicos(sitio);
	}

	@PostMapping("/buscarAlojamiento")
	public List<Alojamiento> buscarAlojamiento(@RequestBody BusquedaAlojaminetoDTO busqueda) {
		return control.obtenerAlojamientos(busqueda);
	}

	@PostMapping("/guardarAlojamiento")
	public void guardarST(@RequestBody Alojamiento alojamiento) {
		control.guardarAlojamientos(alojamiento);
	}

	
	@GetMapping("/obtenerViajes")
	public List<STAlojamientosDTO> obtenerViajes(@RequestParam(name = "idUsuario", required = true) String idUsuario) {
		return control.obtenerViajesSTAlojaminetos(idUsuario);
	}

	@ExceptionHandler(ServicioException.class)
	public ResponseEntity<String> servicioError(ServicioException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

}
