package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.DepartamentoDTO;
import com.cvpsa.appagenciaviajes.business.services.BusService;

public class DepartamentosServiceTest {

	DepartamentoService departamentoService = new DepartamentoService();
	
	@Test
	public void listarDepartamentos_test() {
		
		for (DepartamentoDTO departamentoDTO : departamentoService.listarDepartamentos()) {
			System.out.println(departamentoDTO.getCodDep() + " " + departamentoDTO.getDescDep());
		}
		
	}
	
	@Test
	public void registrarDepartamento_test(){
		
		DepartamentoDTO departamentoDTO = new DepartamentoDTO(departamentoService.obtenerCodigoAutogeneradoDepartamento(), "Cajamarca");
		
		int resultado = departamentoService.registrarDepartamento(departamentoDTO);
		assertTrue(resultado == 1);
	}

	@Test
	public void codigoAutogeneradoDepartamento_test() {

		String resultado = departamentoService.obtenerCodigoAutogeneradoDepartamento();
		System.out.println(resultado);
		
	}
	
	@Test
	public void obtenerDescripcionDepartamento ( ) {
		System.out.println(departamentoService.obtenerDescripcionDepartamento("DEP01"));
	}
}
