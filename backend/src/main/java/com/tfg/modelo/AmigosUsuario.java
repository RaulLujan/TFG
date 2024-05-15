package com.tfg.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AmigosUsuarios")
public class AmigosUsuario {
	@Id
	private String id;
	private String usuarioId;
	private String amigoUsuarioId;

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

	public String getAmigoUsuarioId() {
		return amigoUsuarioId;
	}

	public void setAmigoUsuarioId(String amigoUsuarioId) {
		this.amigoUsuarioId = amigoUsuarioId;
	}

	@Override
	public String toString() {
		return "AmigosUsuario [id=" + id + ", usuarioId=" + usuarioId + ", amigoUsuarioId=" + amigoUsuarioId + "]";
	}

}
