package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.services.BusService;

public class BusServiceTest {

	BusService busService = new BusService();
	
	@Test
	public void listarTodosBuses_test() {
		
		List<BusDTO> listarBuses = busService.listarBuses("");
		for(BusDTO busDTO : listarBuses){
			System.out.println(busDTO.getEstadoBus() + " " + busDTO.getCodBus()+ " " + busDTO.getPlacaBus()+ " " +busDTO.getColorBus()+ " " +busDTO.getMarcaBus()+ " " +busDTO.getAsientoBus());
			
		}
	}
	
	@Test
	public void listarBusEnServicio_test() {
		
		List<BusDTO> listarBuses = busService.listarBuses("EB001");
		for(BusDTO busDTO : listarBuses){
			System.out.println(busDTO.getEstadoBus() + " " + busDTO.getCodBus()+ " " + busDTO.getPlacaBus()+ " " +busDTO.getColorBus()+ " " +busDTO.getMarcaBus()+ " " +busDTO.getAsientoBus());
			
		}
	}
	
	@Test
	public void listarBusesFueraServicio_test() {
		
		List<BusDTO> listarBuses = busService.listarBuses("EB002");
		for(BusDTO busDTO : listarBuses){
			System.out.println(busDTO.getEstadoBus() + " " + busDTO.getCodBus()+ " " + busDTO.getPlacaBus()+ " " +busDTO.getColorBus()+ " " +busDTO.getMarcaBus()+ " " +busDTO.getAsientoBus());
			
		}
	}
	
	@Test
	public void listarBusesEnMantenimiento_test() {
		
		List<BusDTO> listarBuses = busService.listarBuses("EB003");
		for(BusDTO busDTO : listarBuses){
			System.out.println(busDTO.getEstadoBus() + " " + busDTO.getCodBus()+ " " + busDTO.getPlacaBus()+ " " +busDTO.getColorBus()+ " " +busDTO.getMarcaBus()+ " " +busDTO.getAsientoBus());
			
		}
	}
	
	@Test
	public void registrarBus_test(){
		
		BusDTO busDTO = 
				new BusDTO(busService.obtenerCodigoAutogenerado(), "PTP282","Rojo","HYundai",20, "EB003");
		
		int resultado = busService.registrarBus(busDTO);
		assertTrue(resultado == 1);
	}

	@Test
	public void codigoAutogeneradoBus_test() {

		String resultado = busService.obtenerCodigoAutogenerado();
		System.out.println(resultado);
		
	}
}


