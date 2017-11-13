package com.cvpsa.appagenciaviajes.business.bean;

public class BusDTO {

	private String codBus;
	private String placaBus;
	private String colorBus;
	private String marcaBus;
	private int asientoBus;
	private String estadoBus;

	public BusDTO(String codBus, String placaBus, String colorBus, String marcaBus, int asientoBus, String estadoBus) {
		super();
		this.codBus = codBus;
		this.placaBus = placaBus;
		this.colorBus = colorBus;
		this.marcaBus = marcaBus;
		this.asientoBus = asientoBus;
		this.estadoBus = estadoBus;
	}

	public String getCodBus() {
		return codBus;
	}

	public void setCodBus(String codBus) {
		this.codBus = codBus;
	}

	public String getPlacaBus() {
		return placaBus;
	}

	public void setPlacaBus(String placaBus) {
		this.placaBus = placaBus;
	}

	public String getColorBus() {
		return colorBus;
	}

	public void setColorBus(String colorBus) {
		this.colorBus = colorBus;
	}

	public String getMarcaBus() {
		return marcaBus;
	}

	public void setMarcaBus(String marcaBus) {
		this.marcaBus = marcaBus;
	}

	public int getAsientoBus() {
		return asientoBus;
	}

	public void setAsientoBus(int asientoBus) {
		this.asientoBus = asientoBus;
	}

	public String getEstadoBus() {
		return estadoBus;
	}

	public void setEstadoBus(String estadoBus) {
		this.estadoBus = estadoBus;
	}

}
