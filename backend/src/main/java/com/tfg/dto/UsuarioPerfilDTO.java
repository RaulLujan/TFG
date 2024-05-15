package com.tfg.dto;

import com.tfg.modelo.PreferenciasUsuario;
import com.tfg.modelo.Usuario;

public class UsuarioPerfilDTO {

	private Usuario usuario;
	private PreferenciasUsuario preferenciasUsuario;

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

}
