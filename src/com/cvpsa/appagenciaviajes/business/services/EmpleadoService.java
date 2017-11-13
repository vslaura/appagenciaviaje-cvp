package com.cvpsa.appagenciaviajes.business.services;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.EmpleadoDTO;
import com.cvpsa.appagenciaviajes.business.dao.DAOFactory;
import com.cvpsa.appagenciaviajes.business.interfaces.EmpleadoDAO;

public class EmpleadoService {

	DAOFactory factory = DAOFactory.getDAOFactory(1);
	EmpleadoDAO getEmpleadoDAo = factory.getEmpleadoDAO();
	
	public List<EmpleadoDTO> listarEmpleados(){
		return getEmpleadoDAo.listarEmpleados();
	}

	public int registrarEmpleados (EmpleadoDTO empleadoDTO){
		return getEmpleadoDAo.registrarEmpleado(empleadoDTO);
	}
	
	public String obtenerCodigoAutogenerado (){
		return getEmpleadoDAo.obtenerCodigoAutogeneradoEmpleado();
	}
}
