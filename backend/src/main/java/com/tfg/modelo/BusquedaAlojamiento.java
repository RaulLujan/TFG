package com.tfg.modelo;
import java.util.List;

public class BusquedaAlojamiento {

	private String usuarioId;
	private int participantes;
	private String tipoAlojamiento;
	private String rangoPrecio;
	private List<String> facilidades;
	private String creadoEn;

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}

	public String getTipoAlojamiento() {
		return tipoAlojamiento;
	}

	public void setTipoAlojamiento(String tipoAlojamiento) {
		this.tipoAlojamiento = tipoAlojamiento;
	}

	public String getRangoPrecio() {
		return rangoPrecio;
	}

	public void setRangoPrecio(String rangoPrecio) {
		this.rangoPrecio = rangoPrecio;
	}

	public List<String> getFacilidades() {
		return facilidades;
	}

	public void setFacilidades(List<String> facilidades) {
		this.facilidades = facilidades;
	}

	public String getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(String creadoEn) {
		this.creadoEn = creadoEn;
	}

}
