package com.cvpsa.appagenciaviajes.business.interfaces;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.ViajeDTO;


public interface ViajeDAO {

	
	public int registrarViaje(ViajeDTO viajeDTO);
	public List<ViajeDTO> listarViajes();
	public ViajeDTO buscarViaje( String codVje );
	
	public List<ViajeDTO> listarViajesPorOrigenDestinoFecha (String codigoOrigen, String codigoDestino, String fecha);

	public String obtenerCodigoAutogenerado();
	
}
