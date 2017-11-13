package com.cvpsa.appagenciaviajes.business.interfaces;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.EmpleadoDTO;


public interface EmpleadoDAO {

	
	public int registrarEmpleado(EmpleadoDTO empleadoDTO);
	public List<EmpleadoDTO> listarEmpleados();
	public List<EmpleadoDTO> buscarEmpleado(String codEmp);
	public int eliminarEmpleado (String codEmp);
	public int actualizarEmpleado (EmpleadoDTO empleadoDTO);
	
	public String obtenerCodigoAutogeneradoEmpleado();
}
