package com.tfg.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SitiosTuristicos")
public class SitioTuristico {
	@Id
	private String id;
	private String usuarioId;
	private String nombre;
	private String descripcion;
	private String url;
	private int precioEntrada;
	private List<String> actividades;
	private String modoTransporte;
	private String clima;
	private String ubicacion;

	// Constructor

	public SitioTuristico() {
	}

	public SitioTuristico(String nombre, String descripcion, String url, int precioEntrada, List<String> actividades,
			String modoTransporte, String clima, String ubicacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.precioEntrada = precioEntrada;
		this.actividades = actividades;
		this.modoTransporte = modoTransporte;
		this.clima = clima;
		this.ubicacion = ubicacion;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(int precioEntrada) {
		this.precioEntrada = precioEntrada;
	}

	public List<String> getActividades() {
		return actividades;
	}

	public void setActividades(List<String> actividades) {
		this.actividades = actividades;
	}

	public String getModoTransporte() {
		return modoTransporte;
	}

	public void setModoTransporte(String modoTransporte) {
		this.modoTransporte = modoTransporte;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	// Método para crear una lista de sitios turísticos con valores por defecto
	public static List<SitioTuristico> crearSitiosTuristicosPorDefecto() {
		List<SitioTuristico> sitios = new ArrayList<>();
		sitios.add(new SitioTuristico("Parque Nacional de Yosemite",
				"Famoso por sus impresionantes paisajes, senderos de escalada y vistas fotográficas.",
				"https://www.nps.gov/yose/index.htm", 80, Arrays.asList("Senderismo", "Escalada", "Fotografía"),
				"Bicicleta", "Soleado", "California, EE. UU."));
		sitios.add(new SitioTuristico("Chichen Itza",
				"Una de las principales atracciones de México, este sitio histórico ofrece una vista al pasado de la civilización maya.",
				"https://www.chichenitza.com", 50, Arrays.asList("Visitas guiadas", "Fotografía"), "Bicicleta",
				"Soleado", "Yucatán, México"));
		return sitios;
	}

	@Override
	public String toString() {
		return "SitioTuristico [id=" + id + ", usuarioId=" + usuarioId + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", url=" + url + ", precioEntrada=" + precioEntrada + ", actividades=" + actividades
				+ ", modoTransporte=" + modoTransporte + ", clima=" + clima + ", ubicacion=" + ubicacion + "]";
	}

}
