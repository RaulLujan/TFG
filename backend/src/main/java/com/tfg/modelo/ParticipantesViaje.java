package com.tfg.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ParticipantesViajes")
public class ParticipantesViaje {
    @Id
    private String id;
    private String viajeId;
    private String usuarioId;
    private Boolean estadoConfirmacion;
    private String rol;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getViajeId() {
		return viajeId;
	}
	public void setViajeId(String viajeId) {
		this.viajeId = viajeId;
	}
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Boolean getEstadoConfirmacion() {
		return estadoConfirmacion;
	}
	public void setEstadoConfirmacion(Boolean estadoConfirmacion) {
		this.estadoConfirmacion = estadoConfirmacion;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
    
    
}
