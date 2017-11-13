package com.cvpsa.appagenciaviajes.business.bean;

public class EstadoBusDTO {

	private String codigoEstadoBus;
	private String descEstadoBus;
	private String estado;

	public EstadoBusDTO(String codigoEstadoBus, String descEstadoBus, String estado) {
		super();
		this.codigoEstadoBus = codigoEstadoBus;
		this.descEstadoBus = descEstadoBus;
		this.estado = estado;
	}

	public String getCodigoEstadoBus() {
		return codigoEstadoBus;
	}

	public void setCodigoEstadoBus(String codigoEstadoBus) {
		this.codigoEstadoBus = codigoEstadoBus;
	}

	public String getDescEstadoBus() {
		return descEstadoBus;
	}

	public void setDescEstadoBus(String descEstadoBus) {
		this.descEstadoBus = descEstadoBus;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
