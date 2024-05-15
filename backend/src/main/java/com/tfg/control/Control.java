package com.tfg.control;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.dto.BusquedaAlojaminetoDTO;
import com.tfg.dto.BusquedaSTDTO;
import com.tfg.dto.STAlojamientosDTO;
import com.tfg.dto.UsuarioPerfilDTO;
import com.tfg.modelo.Alojamiento;
import com.tfg.modelo.AmigosUsuario;
import com.tfg.modelo.Busqueda;
import com.tfg.modelo.ParticipantesViaje;
import com.tfg.modelo.PreferenciasUsuario;
import com.tfg.modelo.SitioTuristico;
import com.tfg.modelo.Usuario;
import com.tfg.modelo.Viaje;
import com.tfg.openAPICliente.OpenAIClient;
import com.tfg.repositorio.AlojamientoRepository;
import com.tfg.repositorio.AmigosUsuarioRepository;
import com.tfg.repositorio.BusquedaRepository;
import com.tfg.repositorio.ParticipantesViajeRepository;
import com.tfg.repositorio.PreferenciasUsuarioRepository;
import com.tfg.repositorio.SitioTuristicoRepository;
import com.tfg.repositorio.UsuarioRepository;
import com.tfg.repositorio.ViajeRepository;

@Service
public class Control {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ViajeRepository viajeRepository;
	@Autowired
	private PreferenciasUsuarioRepository preferenciasUsuarioRepository;
	@Autowired
	private ParticipantesViajeRepository participantesViajeRepository;
	@Autowired
	private BusquedaRepository busquedaRepository;
	@Autowired
	private AmigosUsuarioRepository amigosUsuarioRepository;
	@Autowired
	private SitioTuristicoRepository sitioTuristicoRepository;
	@Autowired
	private AlojamientoRepository alojamientoRepository;

	public List<Usuario> findAllUsers() {
		return usuarioRepository.findAll();
	}

	public List<Viaje> findAllViajes() {
		return viajeRepository.findAll();
	}

	public List<PreferenciasUsuario> findAllPreferUsers() {
		return preferenciasUsuarioRepository.findAll();
	}

	public List<ParticipantesViaje> findAllParticViajes() {
		return participantesViajeRepository.findAll();
	}

	public List<Busqueda> findAllBusquedas() {
		return busquedaRepository.findAll();
	}

	public List<AmigosUsuario> findAllAmigosUser() {
		return amigosUsuarioRepository.findAll();
	}

	public Usuario consultarUserLogin(Usuario usuario) {
		Usuario usu = usuarioRepository.findByCorreoOrNombreUsuario(usuario.getCorreo(), usuario.getNombreUsuario());
		if (usu != null && usu.getContrasenya() != null && usu.getContrasenya().equals(usuario.getContrasenya()))
			return usu;
		return null;
	}

	public Usuario registrarUser(Usuario usuario) {
		int id = usuarioRepository.findMaxId() != null ? usuarioRepository.findMaxId() : 1;
		id++;
		usuario.setId(id + "");
		usuario.setFotoPerfilUrl("http://example.com/fotos/prueba.jpg");
		usuario.setPreferenciaClimatica("templado");
		usuario.setPreferenciaIdioma("espanol");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
				.withZone(ZoneId.of("UTC"));
		// Obtener la fecha y hora actual en UTC
		String formattedDate = formatter.format(Instant.now());
		usuario.setCreadoEn(formattedDate);
		return usuarioRepository.save(usuario);
	}

	public PreferenciasUsuario obtenerPerfil(String idUsuario) {
		return preferenciasUsuarioRepository.findByUsuarioId(idUsuario);
	}

	public Usuario actualizarPreferenciasUsuario(UsuarioPerfilDTO usuarioPerfilDTO) {
		PreferenciasUsuario preferencias = preferenciasUsuarioRepository
				.findByUsuarioId(usuarioPerfilDTO.getUsuario().getId());
		if (preferencias != null)
			// Actualiza los campos necesarios
			preferencias.actualizarConValoresNoNulos(usuarioPerfilDTO.getPreferenciasUsuario());
		else
			preferencias = usuarioPerfilDTO.getPreferenciasUsuario();
		Usuario usu = usuarioPerfilDTO.getUsuario();
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioPerfilDTO.getUsuario().getId());
		if (usuarioOpt.isPresent()) {
			usu = usuarioOpt.get();
			usu.actualizarConValoresNoNulos(usuarioPerfilDTO.getUsuario());
		}
		preferenciasUsuarioRepository.save(preferencias);
		return usuarioRepository.save(usu);
	}

	public List<Usuario> obtenerListaAmigos(String idUsuario) {
		List<AmigosUsuario> listAmigos = amigosUsuarioRepository.findByUsuarioId(idUsuario);
		List<Usuario> listResult = new ArrayList<Usuario>();
		for (AmigosUsuario amigo : listAmigos) {
			Optional<Usuario> usuarioOpt = usuarioRepository.findById(amigo.getAmigoUsuarioId());
			if (usuarioOpt.isPresent()) {
				listResult.add(usuarioOpt.get());
			}
		}
		return listResult;

	}

	public List<Busqueda> obtenerBusquedas(String idUsuario) {
		return busquedaRepository.findByUsuarioId(idUsuario);
	}

	public List<Viaje> obtenerViajes(String idUsuario) {
		List<ParticipantesViaje> listParticipantes = participantesViajeRepository.findByUsuarioId(idUsuario);
		List<Viaje> listResult = new ArrayList<>();
		for (ParticipantesViaje partViaje : listParticipantes) {
			Optional<Viaje> viajeOpt = viajeRepository.findById(partViaje.getViajeId());
			if (viajeOpt.isPresent()) {
				listResult.add(viajeOpt.get());
			}
		}
		return listResult;

	}

	public List<SitioTuristico> obtenerSitiosTuristicos(BusquedaSTDTO busquedaSTDTO) {
		PreferenciasUsuario preferencias = preferenciasUsuarioRepository
				.findByUsuarioId(busquedaSTDTO.getUsuario().getId());
		busquedaSTDTO.setPreferenciasUsuario(preferencias);

		// LLamada a API ChatGPT con busquedaSTDTO
		 List<SitioTuristico> listResult = buscarSitiosTuristicosOpenAPI(busquedaSTDTO);
		 if(listResult != null) return listResult;

		return SitioTuristico.crearSitiosTuristicosPorDefecto();
	}

	public List<SitioTuristico> buscarSitiosTuristicosOpenAPI(BusquedaSTDTO busquedaSTDTO) {
		try {
			OpenAIClient client = new OpenAIClient();
			return client.fetchTouristSites("Describe tourist sites based on user data: " + busquedaSTDTO.toJson(),
					150, 1);
		} catch (IOException e) {
			System.err.println("Error al realizar la petición: " + e.getMessage());
		}
		return null;
	}

	public List<Alojamiento> obtenerAlojamientos(BusquedaAlojaminetoDTO busquedaAlojaminetoDTO) {
		PreferenciasUsuario preferencias = preferenciasUsuarioRepository
				.findByUsuarioId(busquedaAlojaminetoDTO.getUsuario().getId());
		busquedaAlojaminetoDTO.setPreferenciasUsuario(preferencias);

		// LLamada a API ChatGPT con busquedaSTDTO
		 List<Alojamiento> listResult = buscarAlojamientosOpenAPI(busquedaAlojaminetoDTO);
		 if(listResult != null) return listResult;

		return Alojamiento.crearAlojamientosPorDefecto();
	}
	
	public List<Alojamiento> buscarAlojamientosOpenAPI(BusquedaAlojaminetoDTO busquedaAlojaminetoDTO) {
		try {
			OpenAIClient client = new OpenAIClient();
			return client.fetchAccommodation("Describe accommodation based on user data: " + busquedaAlojaminetoDTO.toJson(),
					150, 1);
		} catch (IOException e) {
			System.err.println("Error al realizar la petición: " + e.getMessage());
		}
		return null;
	}

	public SitioTuristico guardarSitiosTuristicos(SitioTuristico sitio) {
		int id = sitioTuristicoRepository.findMaxId() != null ? sitioTuristicoRepository.findMaxId() : 1;
		id++;
		sitio.setId(id + "");
		return sitioTuristicoRepository.save(sitio);
	}

	public void guardarAlojamientos(Alojamiento alojamiento) {
		int id = alojamientoRepository.findMaxId() != null ? alojamientoRepository.findMaxId() : 1;
		id++;
		alojamiento.setId(id + "");
		alojamientoRepository.save(alojamiento);
	}

	public List<STAlojamientosDTO> obtenerViajesSTAlojaminetos(String idUsuario) {
		List<SitioTuristico> listST = sitioTuristicoRepository.findByUsuarioId(idUsuario);
		System.err.println(listST);
		List<Alojamiento> listAlojamiento = alojamientoRepository.findByIdUsuario(idUsuario);
		System.err.println(listAlojamiento);
		List<STAlojamientosDTO> listResult = new ArrayList<STAlojamientosDTO>();
		for (SitioTuristico sitio : listST) {
			STAlojamientosDTO sta = new STAlojamientosDTO();
			sta.setSitioTuristico(sitio);
			for (Alojamiento alojamiento : listAlojamiento) {
				if (alojamiento.getIdSitio() == sitio.getId())
					sta.setAlojamiento(alojamiento);
			}
			listResult.add(sta);
		}
		return listResult;

	}

}
