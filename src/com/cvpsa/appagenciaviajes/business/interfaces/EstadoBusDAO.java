package com.cvpsa.appagenciaviajes.business.interfaces;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.EstadoBusDTO;


public interface EstadoBusDAO {
	
	public List<EstadoBusDTO> listarEstadoBuses();
	
	public String obtenerDescripcionEstado( String codigoEstadoBus);
	
}
