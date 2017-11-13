package com.cvpsa.appagenciaviajes.business.services;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.PasajeDTO;
import com.cvpsa.appagenciaviajes.business.dao.DAOFactory;
import com.cvpsa.appagenciaviajes.business.interfaces.PasajeDAO;

public class PasajeService {

	DAOFactory daoFactory = DAOFactory.getDAOFactory(1);
	PasajeDAO getPasajeDAO = daoFactory.getPasajeDAO();
	
	public String generarCodigoPasaje ( ) {
		return getPasajeDAO.generarCodigoPasaje();
	}
	
	public int registrarPasaje ( PasajeDTO pasajeDTO ) {
		return getPasajeDAO.registrarPasaje(pasajeDTO);
	}
	
	public List<PasajeDTO> listarPasajeCliente ( String codigoCliente ) {
		return getPasajeDAO.listaPasajesCliente(codigoCliente);
	}
	
}
