package com.tfg.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Busquedas")
public class Busqueda {
	@Id
	private String id;
	private String usuarioId;
	private String tipoBusqueda;
	private String clima;
	private String rangoPrecio;
	private String modoTransporte;
	private String lugaresInteres;
	private String actividadesInteres;
	private String creadoEn;
	private int participantes;

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

	public String getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(String tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getRangoPrecio() {
		return rangoPrecio;
	}

	public void setRangoPrecio(String rangoPrecio) {
		this.rangoPrecio = rangoPrecio;
	}

	public String getModoTransporte() {
		return modoTransporte;
	}

	public void setModoTransporte(String modoTransporte) {
		this.modoTransporte = modoTransporte;
	}

	public String getLugaresInteres() {
		return lugaresInteres;
	}

	public void setLugaresInteres(String lugaresInteres) {
		this.lugaresInteres = lugaresInteres;
	}

	public String getActividadesInteres() {
		return actividadesInteres;
	}

	public void setActividadesInteres(String actividadesInteres) {
		this.actividadesInteres = actividadesInteres;
	}

	public String getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(String creadoEn) {
		this.creadoEn = creadoEn;
	}

	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}

	@Override
	public String toString() {
		return "Busqueda [id=" + id + ", usuarioId=" + usuarioId + ", tipoBusqueda=" + tipoBusqueda + ", clima=" + clima
				+ ", rangoPrecio=" + rangoPrecio + ", modoTransporte=" + modoTransporte + ", lugaresInteres="
				+ lugaresInteres + ", actividadesInteres=" + actividadesInteres + ", creadoEn=" + creadoEn
				+ ", participantes=" + participantes + "]";
	}
	
	

}
