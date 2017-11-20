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
	public void MyregistrarPasaje ( ) {
		
		PasajeDTO pasajeDTO = new PasajeDTO(pasajeService.generarCodigoPasaje(), 8, "2017/10/10", "", "V0001", "Si");
		int resultado = pasajeService.registrarPasaje(pasajeDTO);
		assertTrue(resultado == 1);
	}
	
	
	@Test
	public void listarPasajesCliente ( ) {
		
		for (PasajeDTO pasajeDTO : pasajeService.listarPasajeCliente("C0001") ) {
			System.out.println( pasajeDTO.getCodPje() );
			
		}
	}
	@Test
	public void listaPasajesReservados ( ) {
		
		for (PasajeDTO pasajeDTO : pasajeService.listaPasajeReservados( "V0031")) {
			System.out.println ( pasajeDTO.getCodPje() + " " + pasajeDTO.getNroAsientoPje() + " " + pasajeDTO.getDisponible() );
		}
	}

	@Test
	public void listaPasajesNoReservados ( ) {
		
		for (PasajeDTO pasajeDTO : pasajeService.listaPasajesNoReservados("V0031")) {
			System.out.println ( pasajeDTO.getCodPje() + " " + pasajeDTO.getNroAsientoPje() + " " + pasajeDTO.getDisponible() );
		}
	}
	
	@Test
	public void codigoAutogenerado ( ) {
		System.out.println( pasajeService.generarCodigoPasaje());
	}

}
