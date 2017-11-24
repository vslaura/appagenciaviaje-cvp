package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.PasajeDTO;
import com.cvpsa.appagenciaviajes.business.bean.ViajeDTO;
import com.cvpsa.appagenciaviajes.business.services.ViajeService;

public class ViajeServiceTest {

	ViajeService viajeService = new ViajeService();

	@Test
	public void listarViaje_test() {

		List<ViajeDTO> listaViajes = viajeService.listarViajes();
		for (ViajeDTO viajeDTO : listaViajes) {
			System.err.println(viajeDTO.getCodVje() + " " + viajeDTO.getCodEmp() + " " + viajeDTO.getCodBus());
		}
	}

	@Test
	public void registrarMultiplesViajes_test() {

		// Al inciar la insercion
//		for (int i = 1; i < 10; i++) {
//			ViajeDTO viajeDTO = new ViajeDTO("V000" + i, "EA001", "B000" + i, "2017/12/01", "00:00:00",	// "2017/12/0" + i
//					"2017/12/1" + i, "DEP01", "DEP02", "AG00" + i, 35 + i, 65.00 + (i * 10));

			// A partir de 10...
		for (int i = 0; i < 10; i++) {
			ViajeDTO viajeDTO = new ViajeDTO(viajeService.codigoAutogenerado(), "EA001", "B001" + i, "2017/12/01", "00:00:00", //"2017/12/0" + i
					"2017/12/1" + i, "DEP15", "DEP04", (i == 0) ? "AG010" : "AG00" + i, 35 + i, 65.00 + ( i * 10 ));

			viajeService.registrarViaje(viajeDTO);

			PasajeService pasajeService = new PasajeService();

			for (int j = 1; j <= viajeDTO.getCantidadAsientos(); j++) {
				pasajeService.registrarPasaje(new PasajeDTO(pasajeService.generarCodigoPasaje(), j, "", "", "",
						viajeDTO.getCodVje(), "Si", "No"));
			}
		}

	}


	@Test
	public void registrarViaje_test() {
		assertTrue(viajeService.registrarViaje(new ViajeDTO("V9999", "EC010", "B0002", "2017/12/10", "00:00",
				"2017/12/10", "DEP01", "DEP02", "AG010", 35, 45.00)) != 0);
	}

	@Test
	public void listarViajesPorOrigenDestinoFecha() {

		for (ViajeDTO viajeDTO : viajeService.listarViajesPorOrigenDestinoFecha("DEP01", "DEP02", "2017/11/30")) {
			System.out.println(
					viajeDTO.getCodDepOrigen() + " " + viajeDTO.getCodDepDestino() + " " + viajeDTO.getFecPartiVje());
		}
	}

	@Test
	public void buscarViaje() {

		ViajeDTO viajeDTO = viajeService.buscarViaje("V0001");
		System.out.println(viajeDTO.getCodVje());
	}

	@Test
	public void codigoAutogenerado() {
		System.out.println(viajeService.codigoAutogenerado());
	}

}