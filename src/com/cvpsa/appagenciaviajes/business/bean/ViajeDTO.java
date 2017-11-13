package com.cvpsa.appagenciaviajes.business.bean;

public class ViajeDTO {

	private String codVje;
	private String codEmp;
	private String codBus;
	private String fecPartiVje;
	private String fecLlgarVje;
	private String codDepOrigen;
	private String codDepDestino;
	private String codigoAgencia;

	public ViajeDTO(String codVje, String codEmp, String codBus, String fecPartiVje, String fecLlgarVje,
			String codDepOrigen, String codDepDestino, String codigoAgencia) {
		super();
		this.codVje = codVje;
		this.codEmp = codEmp;
		this.codBus = codBus;
		this.fecPartiVje = fecPartiVje;
		this.fecLlgarVje = fecLlgarVje;
		this.codDepOrigen = codDepOrigen;
		this.codDepDestino = codDepDestino;
		this.codigoAgencia  = codigoAgencia;
	}

	public String getCodVje() {
		return codVje;
	}

	public void setCodVje(String codVje) {
		this.codVje = codVje;
	}

	public String getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}

	public String getCodBus() {
		return codBus;
	}

	public void setCodBus(String codBus) {
		this.codBus = codBus;
	}

	public String getFecPartiVje() {
		return fecPartiVje;
	}

	public void setFecPartiVje(String fecPartiVje) {
		this.fecPartiVje = fecPartiVje;
	}

	public String getFecLlgarVje() {
		return fecLlgarVje;
	}

	public void setFecLlgarVje(String fecLlgarVje) {
		this.fecLlgarVje = fecLlgarVje;
	}

	public String getCodDepOrigen() {
		return codDepOrigen;
	}

	public void setCodDepOrigen(String codDepOrigen) {
		this.codDepOrigen = codDepOrigen;
	}

	public String getCodDepDestino() {
		return codDepDestino;
	}

	public void setCodDepDestino(String codDepDestino) {
		this.codDepDestino = codDepDestino;
	}

	public String getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(String codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

}
