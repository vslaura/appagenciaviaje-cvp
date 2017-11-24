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
	
	public List<PasajeDTO> listaPasajeReservados ( String codigoViaje ) {
		return getPasajeDAO.listaPasajesReservados( codigoViaje );
	}
	
	public List<PasajeDTO> listaPasajesNoReservados ( String codigoViaje) {
		return getPasajeDAO.listaPasajesNoReservados( codigoViaje );
	}
	
	public int adquirirPasaje ( String codigoCliente, String fechaReserva, String horaReserva, String codigoPasaje, String cambio ) {
		return getPasajeDAO.adquirirPasajeCliente(codigoCliente, fechaReserva, horaReserva, codigoPasaje, cambio);
	}
	
	public int deshabilitarPasajeCliente ( String codigoPasaje ) {
		return getPasajeDAO.deshabilitarPasajeCliente(codigoPasaje);
	}
}
