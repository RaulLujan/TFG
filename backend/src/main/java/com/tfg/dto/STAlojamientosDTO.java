package com.tfg.dto;

import com.tfg.modelo.Alojamiento;
import com.tfg.modelo.SitioTuristico;

public class STAlojamientosDTO {

	private SitioTuristico sitioTuristico;
	private Alojamiento alojamiento;

	public SitioTuristico getSitioTuristico() {
		return sitioTuristico;
	}

	public void setSitioTuristico(SitioTuristico sitioTuristico) {
		this.sitioTuristico = sitioTuristico;
	}

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

}
