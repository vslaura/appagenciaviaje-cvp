package com.cvpsa.appagenciaviajes.business.bean;

public class AgenciaDTO {

	private String codigoAgencia;
	private String nombreAgencia;
	private String estadoAgencia;

	public AgenciaDTO(String codigoAgencia, String nombreAgencia, String estadoAgencia) {
		this.codigoAgencia = codigoAgencia;
		this.nombreAgencia = nombreAgencia;
		this.estadoAgencia = estadoAgencia;
	}

	public String getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(String codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public String getNombreAgencia() {
		return nombreAgencia;
	}

	public void setNombreAgencia(String nombreAgencia) {
		this.nombreAgencia = nombreAgencia;
	}

	public String getEstadoAgencia() {
		return estadoAgencia;
	}

	public void setEstadoAgencia(String estadoAgencia) {
		this.estadoAgencia = estadoAgencia;
	}

}
