package com.cvpsa.appagenciaviajes.business.bean;

import java.util.Date;

public class PasajeDTO {

	private String codPje;
	private int nroAsientoPje;
	private String fechComPje;
	private String horaComPsje;
	private String codClie;
	private String codVje;
	private String disponible;

	public PasajeDTO(String codPje, int nroAsientoPje, String fechComPje, String horaComPsje, String codClie, String codVje,
			String disponible) {
		super();
		this.codPje = codPje;
		this.nroAsientoPje = nroAsientoPje;
		this.fechComPje = fechComPje;
		this.horaComPsje = horaComPsje;
		this.codClie = codClie;
		this.codVje = codVje;
		this.disponible = disponible;
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

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public String getHoraComPsje() {
		return horaComPsje;
	}

	public void setHoraComPsje(String horaComPsje) {
		this.horaComPsje = horaComPsje;
	}

}
