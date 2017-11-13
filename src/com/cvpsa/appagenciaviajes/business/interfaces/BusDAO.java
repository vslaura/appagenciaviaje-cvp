package com.cvpsa.appagenciaviajes.business.interfaces;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;


public interface BusDAO {
	
	public int registrarBus(BusDTO busDTO);
	
	public List<BusDTO> listarBuses(String estado);
	
	public List<BusDTO> buscarBus( String codBus);
	public int eliminarBus (String codBus);
	public int actualizarBus (BusDTO busDTO);
	
	public String obtenerCodigoAutogenerado();
}
