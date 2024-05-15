package com.tfg.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuarios")
public class Usuario {
    @Id
    private String id;
    private int idUsuario;
    private String nombreUsuario;
    private String correo;
    private String contrasenya;
    private String numeroTelefono;
    private String nombreCompleto;
    private String fotoPerfilUrl;
    private int edad;
    private String estadoCivil;
    private int tamanyoFamilia;
    private String preferenciaClimatica;
    private boolean tieneVehiculo;
    private String preferenciaIdioma;
    private String creadoEn;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getFotoPerfilUrl() {
		return fotoPerfilUrl;
	}
	public void setFotoPerfilUrl(String fotoPerfilUrl) {
		this.fotoPerfilUrl = fotoPerfilUrl;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public int getTamanyoFamilia() {
		return tamanyoFamilia;
	}
	public void setTamanyoFamilia(int tamanyoFamilia) {
		this.tamanyoFamilia = tamanyoFamilia;
	}
	public String getPreferenciaClimatica() {
		return preferenciaClimatica;
	}
	public void setPreferenciaClimatica(String preferenciaClimatica) {
		this.preferenciaClimatica = preferenciaClimatica;
	}
	public boolean isTieneVehiculo() {
		return tieneVehiculo;
	}
	public void setTieneVehiculo(boolean tieneVehiculo) {
		this.tieneVehiculo = tieneVehiculo;
	}
	public String getPreferenciaIdioma() {
		return preferenciaIdioma;
	}
	public void setPreferenciaIdioma(String preferenciaIdioma) {
		this.preferenciaIdioma = preferenciaIdioma;
	}
	public String getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(String creadoEn) {
		this.creadoEn = creadoEn;
	}
	
	 // Método para actualizar campos no nulos
    public void actualizarConValoresNoNulos(Usuario nuevoUsuario) {
        if (nuevoUsuario.getNombreUsuario() != null)
            this.nombreUsuario = nuevoUsuario.getNombreUsuario();
        if (nuevoUsuario.getCorreo() != null)
            this.correo = nuevoUsuario.getCorreo();
        if (nuevoUsuario.getContrasenya() != null)
            this.contrasenya = nuevoUsuario.getContrasenya();
        if (nuevoUsuario.getNumeroTelefono() != null)
            this.numeroTelefono = nuevoUsuario.getNumeroTelefono();
        if (nuevoUsuario.getNombreCompleto() != null)
            this.nombreCompleto = nuevoUsuario.getNombreCompleto();
        if (nuevoUsuario.getFotoPerfilUrl() != null)
            this.fotoPerfilUrl = nuevoUsuario.getFotoPerfilUrl();
        if (nuevoUsuario.getEdad() != 0)
            this.edad = nuevoUsuario.getEdad();
        if (nuevoUsuario.getEstadoCivil() != null)
            this.estadoCivil = nuevoUsuario.getEstadoCivil();
        if (nuevoUsuario.getTamanyoFamilia() != 0)
            this.tamanyoFamilia = nuevoUsuario.getTamanyoFamilia();
        if (nuevoUsuario.getPreferenciaClimatica() != null)
            this.preferenciaClimatica = nuevoUsuario.getPreferenciaClimatica();
        if (nuevoUsuario.getPreferenciaIdioma() != null)
            this.preferenciaIdioma = nuevoUsuario.getPreferenciaIdioma();
    }
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", correo="
				+ correo + ", contrasenya=" + contrasenya + ", numeroTelefono=" + numeroTelefono + ", nombreCompleto="
				+ nombreCompleto + ", fotoPerfilUrl=" + fotoPerfilUrl + ", edad=" + edad + ", estadoCivil="
				+ estadoCivil + ", tamanyoFamilia=" + tamanyoFamilia + ", preferenciaClimatica=" + preferenciaClimatica
				+ ", tieneVehiculo=" + tieneVehiculo + ", preferenciaIdioma=" + preferenciaIdioma + ", creadoEn="
				+ creadoEn + "]";
	}
	
	

    
}
