package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
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
	public void registrarViaje_test() {

		ViajeDTO viajeDTO = new ViajeDTO("V0003", "EA001", "B0001", "2017/11/30", "2017/12/30", "DEP02", "DEP03", "AG001");
//		ViajeDTO viajeDTO = new ViajeDTO("V0003", "EF003", "B0003", null, null, null, null);

		int resultado = viajeService.registrarViaje(viajeDTO);
		assertTrue(resultado == 1);
	}

	@Test
	public void listarViajesPorOrigenDestinoFecha() {

		for (ViajeDTO viajeDTO : viajeService.listarViajesPorOrigenDestinoFecha("DEP01", "DEP02", "2017/11/30")) {
			System.out.println(viajeDTO.getCodDepOrigen() + " " + viajeDTO.getCodDepDestino() + " " + viajeDTO.getFecPartiVje());
		}
	}

	@Test
	public void buscarViaje () {
		
		ViajeDTO viajeDTO = viajeService.buscarViaje("V0001");
		System.out.println(viajeDTO.getCodVje());
	}
}