package com.cvpsa.appagenciaviajes.business.interfaces;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.DepartamentoDTO;


public interface DepartamentoDAO {
	
	public int registrarDepartamento(DepartamentoDTO departamentoDTO);
	
	public List<DepartamentoDTO> listarDepartamentos();
	
	public String obtenerCodigoAutogeneradoDepartamento();
	
	public String obtenerDescripcionDepartamento ( String codigoDepartamento );
}
