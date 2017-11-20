package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.EmpleadoDTO;
import com.cvpsa.appagenciaviajes.business.services.EmpleadoService;
import com.github.javafaker.Faker;

public class EmpleadoServiceTest {

	EmpleadoService empleadoService = new EmpleadoService();
	Faker faker = new Faker();
	
	@Test
	public void listarEmpleados_test() {
		
		List<EmpleadoDTO> listaEmpleados = empleadoService.listarEmpleados();
		for(EmpleadoDTO empleadoDTO : listaEmpleados){
			System.out.println(empleadoDTO.getCodEmp() + " " +  empleadoDTO.getDniEmp() + " " + empleadoDTO.getNomEmp() + " " + empleadoDTO.getApellEmp() + " " + empleadoDTO.getCategoria());
		}			
		
	}
	
	@Test
	public void registrarEmpleado_test(){
		
		for (int i = 0; i < 18; i++) {
			EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleadoService.obtenerCodigoAutogenerado(), faker.code().ean8(), faker.name().firstName(), faker.name().lastName() + " " + faker.name().lastName(), 2);
			System.out.println(empleadoDTO.getNomEmp() + " " + empleadoDTO.getApellEmp());
			empleadoService.registrarEmpleados(empleadoDTO);
		}
		
	}
	
	@Test
	public void codigoAutogeneradoEmpleado_test() {

		String resultado = empleadoService.obtenerCodigoAutogenerado();
		System.out.println(resultado);
		
	}

}
