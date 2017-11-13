package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.PasajeDTO;

public class PasajeServiceTest {

	PasajeService pasajeService = new PasajeService();
	
	@Test
	public void generarCodigoPasajetest() {
		System.out.println(pasajeService.generarCodigoPasaje());
		
	}
	
	@Test
	public void registrarPasaje ( ) {
		
		PasajeDTO pasajeDTO = new PasajeDTO(pasajeService.generarCodigoPasaje(), 8, 90.00, "2017/10/10", "C0001", "V0001");
		int resultado = pasajeService.registrarPasaje(pasajeDTO);
		assertTrue(resultado == 1);
	}
	
	
	@Test
	public void listarPasajesCliente ( ) {
		
		for (PasajeDTO pasajeDTO : pasajeService.listarPasajeCliente("C0001") ) {
			System.out.println( pasajeDTO.getCodPje() );
			
		}
	}

}
