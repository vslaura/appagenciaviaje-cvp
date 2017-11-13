package com.cvpsa.appagenciaviajes.business.bean;

public class CategoriaDTO {

	private int codCate;
	private String tipoCate;

	public CategoriaDTO(int codCate, String tipoCate) {
		super();
		this.codCate = codCate;
		this.tipoCate = tipoCate;
	}

	public int getCodCate() {
		return codCate;
	}

	public void setCodCate(int codCate) {
		this.codCate = codCate;
	}

	public String getTipoCate() {
		return tipoCate;
	}

	public void setTipoCate(String tipoCate) {
		this.tipoCate = tipoCate;
	}

}
