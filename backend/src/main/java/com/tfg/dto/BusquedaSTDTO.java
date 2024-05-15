package com.tfg.dto;

import com.google.gson.Gson;
import com.tfg.modelo.Busqueda;
import com.tfg.modelo.PreferenciasUsuario;
import com.tfg.modelo.Usuario;

public class BusquedaSTDTO {
	
	private Busqueda busqueda;
	private Usuario usuario;
	private PreferenciasUsuario preferenciasUsuario;
	
	public Busqueda getBusqueda() {
		return busqueda;
	}
	public void setBusqueda(Busqueda busqueda) {
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
	
    // Método para convertir el objeto a un String en formato JSON
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
	
	@Override
	public String toString() {
		return "BusquedaSTDTO [busqueda=" + busqueda + ", usuario=" + usuario + ", preferenciasUsuario="
				+ preferenciasUsuario + "]";
	}
	
	

}
