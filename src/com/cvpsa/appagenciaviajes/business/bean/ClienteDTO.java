package com.cvpsa.appagenciaviajes.business.bean;

/**
 * 
 * Esta clase representa al cliente quien realizará la compra de pasajes-
 * 
 * @author
 *
 */
public class ClienteDTO {

	private String codCli;
	private String dniCli;
	private String nomCli;
	private String apeCli;
	private String emailCli;
	private String usuarioCli;
	private String claveCli;

	public ClienteDTO(String codCli, String dniCli, String nomCli, String apeCli, String emailCli, String usuarioCli,
			String claveCli) {
		super();
		this.codCli = codCli;
		this.dniCli = dniCli;
		this.nomCli = nomCli;
		this.apeCli = apeCli;
		this.emailCli = emailCli;
		this.usuarioCli = usuarioCli;
		this.claveCli = claveCli;
	}

	public String getCodCli() {
		return codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	public String getDniCli() {
		return dniCli;
	}

	public void setDniCli(String dniCli) {
		this.dniCli = dniCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getApeCli() {
		return apeCli;
	}

	public void setApeCli(String apeCli) {
		this.apeCli = apeCli;
	}

	public String getEmailCli() {
		return emailCli;
	}

	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}

	public String getUsuarioCli() {
		return usuarioCli;
	}

	public void setUsuarioCli(String usuarioCli) {
		this.usuarioCli = usuarioCli;
	}

	public String getClaveCli() {
		return claveCli;
	}

	public void setClaveCli(String claveCli) {
		this.claveCli = claveCli;
	}

}