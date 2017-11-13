package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.EmpleadoDTO;
import com.cvpsa.appagenciaviajes.business.services.EmpleadoService;

public class EmpleadoServiceTest {

	EmpleadoService empleadoService = new EmpleadoService();
	
	
	@Test
	public void listarEmpleados_test() {
		
		List<EmpleadoDTO> listaEmpleados = empleadoService.listarEmpleados();
		for(EmpleadoDTO empleadoDTO : listaEmpleados){
			System.out.println(empleadoDTO.getCodEmp() + " " +  empleadoDTO.getDniEmp() + " " + empleadoDTO.getNomEmp() + " " + empleadoDTO.getApellEmp() + " " + empleadoDTO.getCategoria());
		}			
		
	}
	
	@Test
	public void registrarEmpleado_test(){
		EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleadoService.obtenerCodigoAutogenerado(),"90877654", "Luis", "Martines Peres", 2);
		
		int resultado = empleadoService.registrarEmpleados(empleadoDTO);
		assertTrue(resultado == 1);
	}
	
	@Test
	public void codigoAutogeneradoEmpleado_test() {

		String resultado = empleadoService.obtenerCodigoAutogenerado();
		System.out.println(resultado);
		
	}

}
