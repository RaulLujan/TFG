package com.tfg.dto;

import com.google.gson.Gson;
import com.tfg.modelo.BusquedaAlojamiento;
import com.tfg.modelo.PreferenciasUsuario;
import com.tfg.modelo.SitioTuristico;
import com.tfg.modelo.Usuario;

public class BusquedaAlojaminetoDTO {
	
	private BusquedaAlojamiento busqueda;
	private Usuario usuario;
	private PreferenciasUsuario preferenciasUsuario;
	private SitioTuristico sitio;
	
	public BusquedaAlojamiento getBusqueda() {
		return busqueda;
	}
	public void setBusqueda(BusquedaAlojamiento busqueda) {
		this.busqueda = busqueda;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public PreferenciasUsuario getPreferenciasUsuario() {
		return preferenciasUsuario;
	}
	public void setPreferenciasUsuario(PreferenciasUsuario preferenciasUsuario) {
		this.preferenciasUsuario = preferenciasUsuario;
	}

	public SitioTuristico getSitio() {
		return sitio;
	}
	public void setSitio(SitioTuristico sitio) {
		this.sitio = sitio;
	}
	
	// Método para convertir el objeto a un String en formato JSON
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	@Override
	public String toString() {
		return "BusquedaAlojaminetoDTO [busqueda=" + busqueda + ", usuario=" + usuario + ", preferenciasUsuario="
				+ preferenciasUsuario + "]";
	}
	
	

}
