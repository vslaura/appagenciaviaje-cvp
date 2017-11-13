package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.EstadoBusDTO;
import com.cvpsa.appagenciaviajes.business.services.EstadoBusService;

public class EstadoBusServiceTest {

	EstadoBusService estadoBusService = new EstadoBusService();
	
	@Test
	public void listadoEstadoBuses_test() {
		
		for (EstadoBusDTO estadoBus : estadoBusService.listarEstadoBuses()) {
			System.out.println(estadoBus.getCodigoEstadoBus() + " " + estadoBus.getDescEstadoBus() + " " + estadoBus.getEstado());
		}
		
	}
	
	@Test
	public void obtenerDescripcionEstadoBus_Test ( ) {
		
		String resultado = estadoBusService.obtenerDescripcionEstado("EB001");
		System.out.println(resultado);
	}

}
