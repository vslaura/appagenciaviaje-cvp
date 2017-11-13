package com.cvpsa.appagenciaviajes.business.bean;

public class EmpleadoDTO {

	private String codEmp;
	private String dniEmp;
	private String nomEmp;
	private String apellEmp;
	private int categoria;

	public EmpleadoDTO(String codEmp, String dniEmp, String nomEmp, String apellEmp, int categoria) {
		super();
		this.codEmp = codEmp;
		this.dniEmp = dniEmp;
		this.nomEmp = nomEmp;
		this.apellEmp = apellEmp;
		this.categoria = categoria;
	}

	public String getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}

	public String getDniEmp() {
		return dniEmp;
	}

	public void setDniEmp(String dniEmp) {
		this.dniEmp = dniEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getApellEmp() {
		return apellEmp;
	}

	public void setApellEmp(String apellEmp) {
		this.apellEmp = apellEmp;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

}
