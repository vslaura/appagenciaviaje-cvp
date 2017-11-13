package com.cvpsa.appagenciaviajes.business.services;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.ViajeDTO;
import com.cvpsa.appagenciaviajes.business.dao.DAOFactory;
import com.cvpsa.appagenciaviajes.business.interfaces.ViajeDAO;


public class ViajeService {

	DAOFactory factory = DAOFactory.getDAOFactory(1);
	ViajeDAO getViajeDAO = factory.getViajeDAO();
	
	public List<ViajeDTO> listarViajes (){
		return getViajeDAO.listarViajes();
	}
	
	public int registrarViaje (ViajeDTO viajeDTO){
		return getViajeDAO.registrarViaje(viajeDTO);
	}
	
	public List<ViajeDTO> listarViajesPorOrigenDestinoFecha ( String codigoOrigen, String codigoDestino, String fecha ) {
		return getViajeDAO.listarViajesPorOrigenDestinoFecha(codigoOrigen, codigoDestino, fecha);
	}
	
	public ViajeDTO buscarViaje ( String codVje ){
		return getViajeDAO.buscarViaje(codVje);
	}
}
