package com.cvpsa.appagenciaviajes.business.services;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.EstadoBusDTO;
import com.cvpsa.appagenciaviajes.business.dao.DAOFactory;
import com.cvpsa.appagenciaviajes.business.interfaces.BusDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.EstadoBusDAO;

public class EstadoBusService {

	DAOFactory factory = DAOFactory.getDAOFactory(1);
	EstadoBusDAO getEstadoBusDAO = factory.getEstadoBusDAO();

	public List<EstadoBusDTO> listarEstadoBuses() {
		return getEstadoBusDAO.listarEstadoBuses();
	}

	public String obtenerDescripcionEstado ( String codigoEstadoBus ){
		return getEstadoBusDAO.obtenerDescripcionEstado(codigoEstadoBus);
	}
	
}
