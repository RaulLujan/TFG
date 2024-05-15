package com.tfg.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Alojamientos")
public class Alojamiento {
	@Id
    private String id;  
    private String idUsuario;
    private String idSitio;
    private String nombre;
    private String descripcion;
    private String precioPorNoche;
    private List<String> facilidades;
    private String tipoAlojamiento;
    private String distancia;
    private String urlReserva;
    private double valoracion;

    // Constructor
    public Alojamiento() {
    }

    
    public Alojamiento(String nombre, String descripcion, 
                       String precioPorNoche, List<String> facilidades, String tipoAlojamiento, 
                       String distancia, String urlReserva, double valoracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorNoche = precioPorNoche;
        this.facilidades = facilidades;
        this.tipoAlojamiento = tipoAlojamiento;
        this.distancia = distancia;
        this.urlReserva = urlReserva;
        this.valoracion = valoracion;
    }

    // Getters y Setters
    // Incluidos para permitir la manipulación y acceso a las propiedades del objeto.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdSitio() {
        return idSitio;
    }

    public void setIdSitio(String idSitio) {
        this.idSitio = idSitio;
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

    public String getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(String precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public List<String> getFacilidades() {
        return facilidades;
    }

    public void setFacilidades(List<String> facilidades) {
        this.facilidades = facilidades;
    }

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public String getUrlReserva() {
        return urlReserva;
    }

    public void setUrlReserva(String urlReserva) {
        this.urlReserva = urlReserva;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
    
    public static List<Alojamiento> crearAlojamientosPorDefecto() {
        List<Alojamiento> alojamientos = new ArrayList<>();
        alojamientos.add(new Alojamiento(
            "Yosemite View Lodge",
            "Ubicado a las puertas del Parque Nacional de Yosemite, este hotel ofrece vistas espectaculares y acceso fácil a las rutas de senderismo.",
            "150",
            Arrays.asList("Parking gratuito", "Desayuno incluido", "Internet Wi-Fi"),
            "Hotel",
            "0.5 km",
            "https://www.yosemiteviewlodge.com/reservar",
            4.5
        ));
        alojamientos.add(new Alojamiento(
            "The Majestic Yosemite Hotel",
            "Un hotel histórico con interiores lujosos y servicio de clase mundial, situado dentro del parque.",
            "350",
            Arrays.asList("Parking con valet", "Desayuno gourmet incluido", "Internet Wi-Fi"),
            "Hotel",
            "2 km",
            "https://www.travelyosemite.com/lodging/the-majestic-yosemite-hotel/",
            4.8
        ));
        return alojamientos;
    }

	@Override
	public String toString() {
		return "Alojamiento [id=" + id + ", idUsuario=" + idUsuario + ", idSitio=" + idSitio + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", precioPorNoche=" + precioPorNoche + ", facilidades=" + facilidades
				+ ", tipoAlojamiento=" + tipoAlojamiento + ", distancia=" + distancia + ", urlReserva=" + urlReserva
				+ ", valoracion=" + valoracion + "]";
	}
    
    
}
