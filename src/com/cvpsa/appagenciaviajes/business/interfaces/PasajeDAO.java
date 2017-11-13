package com.cvpsa.appagenciaviajes.business.interfaces;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.PasajeDTO;


public interface PasajeDAO {

	public int registrarPasaje(PasajeDTO pasajeDTO);
	public List<PasajeDTO> listarPasajes();
	public List<PasajeDTO> buscarPasaje( String codPje);
	public int eliminarPasaje (String codPje);
	public int actualizarPasaje (PasajeDTO pasajeDTO);
	
	public String generarCodigoPasaje ( );
	
	public List<PasajeDTO> listaPasajesCliente ( String codigoCliente );
	
}
