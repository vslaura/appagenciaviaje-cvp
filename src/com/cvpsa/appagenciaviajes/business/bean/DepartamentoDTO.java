package com.cvpsa.appagenciaviajes.business.bean;

public class DepartamentoDTO {

	private String codDep;
	private String descDep;

	public DepartamentoDTO(String codDep, String descDep) {
		super();
		this.codDep = codDep;
		this.descDep = descDep;
	}

	public String getCodDep() {
		return codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getDescDep() {
		return descDep;
	}

	public void setDescDep(String descDep) {
		this.descDep = descDep;
	}

}
