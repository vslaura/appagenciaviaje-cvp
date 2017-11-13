package com.cvpsa.appagenciaviajes.business.services;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.DepartamentoDTO;
import com.cvpsa.appagenciaviajes.business.dao.DAOFactory;
import com.cvpsa.appagenciaviajes.business.interfaces.BusDAO;
import com.cvpsa.appagenciaviajes.business.interfaces.DepartamentoDAO;

public class DepartamentoService {

	DAOFactory factory = DAOFactory.getDAOFactory(1);
	DepartamentoDAO getDepartamentoDAO = factory.getDepartamentoDAO();

	public List<DepartamentoDTO> listarDepartamentos() {
		return getDepartamentoDAO.listarDepartamentos();
	}

	public int registrarDepartamento (DepartamentoDTO departamentoDTO){
		return getDepartamentoDAO.registrarDepartamento(departamentoDTO);
	}
	
	public String obtenerCodigoAutogeneradoDepartamento (){
		return getDepartamentoDAO.obtenerCodigoAutogeneradoDepartamento();
	}
	
	public String obtenerDescripcionDepartamento ( String codigoDepartamento ) {
		return getDepartamentoDAO.obtenerDescripcionDepartamento(codigoDepartamento);
	}
	
}
