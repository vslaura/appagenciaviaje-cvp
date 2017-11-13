package com.cvpsa.appagenciaviajes.business.services;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.dao.DAOFactory;
import com.cvpsa.appagenciaviajes.business.interfaces.BusDAO;

public class BusService {

	DAOFactory factory = DAOFactory.getDAOFactory(1);
	BusDAO getBusDAO = factory.getBusDAO();

	public List<BusDTO> listarBuses(String estado) {
		return getBusDAO.listarBuses(estado);
	}

	public int registrarBus (BusDTO busDTO){
		return getBusDAO.registrarBus(busDTO);
	}
	
	public String obtenerCodigoAutogenerado() {
		return getBusDAO.obtenerCodigoAutogenerado();
	}
}
