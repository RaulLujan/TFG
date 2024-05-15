package com.tfg.modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Viajes")
public class Viaje {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String descripcionSitioTuristico;
    private String descripcionAlojamiento;
    private String estado;
    private Float estimacionPresupuesto;
    private String fechaInicio;
    private String fechaFin;
    private String creadoEn;
    
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
	public String getDescripcionSitioTuristico() {
		return descripcionSitioTuristico;
	}
	public void setDescripcionSitioTuristico(String descripcionSitioTuristico) {
		this.descripcionSitioTuristico = descripcionSitioTuristico;
	}
	public String getDescripcionAlojamiento() {
		return descripcionAlojamiento;
	}
	public void setDescripcionAlojamiento(String descripcionAlojamiento) {
		this.descripcionAlojamiento = descripcionAlojamiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Float getEstimacionPresupuesto() {
		return estimacionPresupuesto;
	}
	public void setEstimacionPresupuesto(Float estimacionPresupuesto) {
		this.estimacionPresupuesto = estimacionPresupuesto;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(String creadoEn) {
		this.creadoEn = creadoEn;
	}
    
    
    
}
