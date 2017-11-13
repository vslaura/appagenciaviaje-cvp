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

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;

	public abstract ClienteDAO getClienteDAO();
	/*public abstract UsuarioDAO getUsuarioDAO();
	public abstract AsistenciaDAO getAsistenciaDAO();
	public abstract ReporteAsistenciaDAO getRepoAsistencia();
	 * */
	
	public abstract CategoriaDAO getCategoriaDAO();
	public abstract EmpleadoDAO getEmpleadoDAO();
	public abstract BusDAO getBusDAO();
	public abstract ViajeDAO getViajeDAO();
	public abstract PasajeDAO getPasajeDAO();
	public abstract EstadoBusDAO getEstadoBusDAO();
	public abstract DepartamentoDAO getDepartamentoDAO();
	public abstract AgenciaDAO geAgenciaDAO();
	
	public static DAOFactory getDAOFactory(int qFactory) {
		switch (qFactory) {
		case MYSQL:
			return new MySQLDAOFactory();
		default:
			return null;
		}
	}
}
