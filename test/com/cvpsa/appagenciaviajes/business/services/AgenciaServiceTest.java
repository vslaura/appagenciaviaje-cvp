package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class AgenciaServiceTest {

	AgenciaService agenciaService = new AgenciaService();
	
	@Test
	public void obtenerDescripcionAgencia_test() {
		System.out.println(agenciaService.obtenerDescripcionAgencia("AG001"));
	}

}
