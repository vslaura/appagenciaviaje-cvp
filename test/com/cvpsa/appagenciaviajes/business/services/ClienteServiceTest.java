package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;

public class ClienteServiceTest {

	ClienteService clienteService = new ClienteService();

	@Test
	public void listarClientes_test() {

		for (ClienteDTO clienteDTO : clienteService.listarClientes()) {
			System.out.println(
					clienteDTO.getCodCli() + " " + clienteDTO.getNomCli()+" " +clienteDTO.getApeCli());
		}
	}

	@Test
	public void registrarCliente_test() {
	
		ClienteDTO clienteDTO = new ClienteDTO(clienteService.obtenerCodigoAutogenerado(), "45879568", "Juan",
				"Montoya Tipiana", "jorge@gmail.com", "jorge2000", "miClave");

		int resultado = clienteService.registrarEmpleados(clienteDTO);
		assertTrue(resultado == 1);
	}

	@Test
	public void codigoAutogeneradoBus_test() {

		String resultado = clienteService.obtenerCodigoAutogenerado();
		System.out.println(resultado);

	}
	
	@Test
	public void buscarCliente_Test ( ) {
		System.out.println(clienteService.buscarCliente("pedro300", "miClave").getNomCli());
	}
}
