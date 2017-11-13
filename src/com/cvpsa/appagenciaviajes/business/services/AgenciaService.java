package com.cvpsa.appagenciaviajes.business.services;

import com.cvpsa.appagenciaviajes.business.dao.DAOFactory;
import com.cvpsa.appagenciaviajes.business.interfaces.AgenciaDAO;

public class AgenciaService {

	DAOFactory daoFactory = DAOFactory.getDAOFactory(1);
	AgenciaDAO getAgenciaDAO = daoFactory.geAgenciaDAO();
	
	public String obtenerDescripcionAgencia ( String codigoAgencia ) {
		return getAgenciaDAO.obtenerDescripcionAgencia(codigoAgencia);
	}
	
}
