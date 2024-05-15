package com.tfg.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PreferenciasUsuarios")
public class PreferenciasUsuario {
	@Id
	private String id;
	private String usuarioId;
	private String nivelAventura;
	private Boolean interesCultural;
	private Boolean interesDeportivo;
	private Boolean interesRelajacion;
	private Boolean amorNaturaleza;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNivelAventura() {
		return nivelAventura;
	}

	public void setNivelAventura(String nivelAventura) {
		this.nivelAventura = nivelAventura;
	}

	public Boolean getInteresCultural() {
		return interesCultural;
	}

	public void setInteresCultural(Boolean interesCultural) {
		this.interesCultural = interesCultural;
	}

	public Boolean getInteresDeportivo() {
		return interesDeportivo;
	}

	public void setInteresDeportivo(Boolean interesDeportivo) {
		this.interesDeportivo = interesDeportivo;
	}

	public Boolean getInteresRelajacion() {
		return interesRelajacion;
	}

	public void setInteresRelajacion(Boolean interesRelajacion) {
		this.interesRelajacion = interesRelajacion;
	}

	public Boolean getAmorNaturaleza() {
		return amorNaturaleza;
	}

	public void setAmorNaturaleza(Boolean amorNaturaleza) {
		this.amorNaturaleza = amorNaturaleza;
	}

	public void actualizarConValoresNoNulos(PreferenciasUsuario nuevasPreferencias) {
		if (nuevasPreferencias.getUsuarioId() != null)
			this.usuarioId = nuevasPreferencias.getUsuarioId();
		if (nuevasPreferencias.getNivelAventura() != null)
			this.nivelAventura = nuevasPreferencias.getNivelAventura();
		if (nuevasPreferencias.getInteresCultural() != null)
			this.interesCultural = nuevasPreferencias.getInteresCultural();
		if (nuevasPreferencias.getInteresDeportivo() != null)
			this.interesDeportivo = nuevasPreferencias.getInteresDeportivo();
		if (nuevasPreferencias.getInteresRelajacion() != null)
			this.interesRelajacion = nuevasPreferencias.getInteresRelajacion();
		if (nuevasPreferencias.getAmorNaturaleza() != null)
			this.amorNaturaleza = nuevasPreferencias.getAmorNaturaleza();
	}

}
