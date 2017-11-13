package com.cvpsa.appagenciaviajes.business.dao;

import com.cvpsa.appagenciaviajes.business.interfaces.AgenciaDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.BusDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.CategoriaDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.ClienteDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.DepartamentoDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.EmpleadoDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.EstadoBusDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.PasajeDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.ViajeDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new MySQLClienteDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new MySQLCategoriaDAO();
	}

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		// TODO Auto-generated method stub
		return new MySQLEmpleadoDAO();
	}

	@Override
	public BusDAO getBusDAO() {
		// TODO Auto-generated method stub
		return new MySQLBusDAO();
	}

	@Override
	public ViajeDAO getViajeDAO() {
		// TODO Auto-generated method stub
		return new MySQLViajeDAO();
	}

	@Override
	public PasajeDAO getPasajeDAO() {
		// TODO Auto-generated method stub
		return new MySQLPasajeDAO();
	}

	@Override
	public EstadoBusDAO getEstadoBusDAO() {
		// TODO Auto-generated method stub
		return new MySQLEstadoBusDAO();
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		// TODO Auto-generated method stub
		return new MySQLDepartamentoDAO();
	}

	@Override
	public AgenciaDAO geAgenciaDAO() {
		// TODO Auto-generated method stub
		return new MySQLAgenciaDAO();
	}

	
}
