package com.cvpsa.appagenciaviajes.business.bean;

import java.util.Date;

public class PasajeDTO {

	private String codPje;
	private int nroAsientoPje;
	private Double precPje;
	private String fechComPje;
	private String codClie;
	private String codVje;

	public PasajeDTO(String codPje, int nroAsientoPje, Double precPje, String fechComPje, String codClie, String codVje) {
		super();
		this.codPje = codPje;
		this.nroAsientoPje = nroAsientoPje;
		this.precPje = precPje;
		this.fechComPje = fechComPje;
		this.codClie = codClie;
		this.codVje = codVje;
	}

	public String getCodPje() {
		return codPje;
	}

	public void setCodPje(String codPje) {
		this.codPje = codPje;
	}

	public int getNroAsientoPje() {
		return nroAsientoPje;
	}

	public void setNroAsientoPje(int nroAsientoPje) {
		this.nroAsientoPje = nroAsientoPje;
	}

	public Double getPrecPje() {
		return precPje;
	}

	public void setPrecPje(Double precPje) {
		this.precPje = precPje;
	}

	public String getFechComPje() {
		return fechComPje;
	}

	public void setFechComPje(String fechComPje) {
		this.fechComPje = fechComPje;
	}

	public String getCodClie() {
		return codClie;
	}

	public void setCodClie(String codClie) {
		this.codClie = codClie;
	}

	public String getCodVje() {
		return codVje;
	}

	public void setCodVje(String codVje) {
		this.codVje = codVje;
	}

}
