package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;
import com.github.javafaker.Faker;

public class ClienteServiceTest {

	ClienteService clienteService = new ClienteService();
	Faker faker = new Faker ( new Locale( "EN" ) );

	@Test
	public void listarClientes_test() {

		for (ClienteDTO clienteDTO : clienteService.listarClientes()) {
			System.out.println(
					clienteDTO.getCodCli() + " " + clienteDTO.getNomCli()+" " +clienteDTO.getApeCli());
		}
	}

	@Test
	public void registrarCliente_test() {

		int resultado = 0;
		
//		for (int i = 0; i < 10; i++) {
			ClienteDTO clienteDTO = new ClienteDTO(clienteService.obtenerCodigoAutogenerado(), faker.code().ean8(), faker.name().firstName(),
					faker.name().lastName() + faker.name().lastName(), faker.name().firstName() + "@gmail.com", faker.name().firstName(), faker.name().lastName());
			System.out.println(clienteDTO.getCodCli() + " " + clienteDTO.getNomCli() + " " + clienteDTO.getApeCli() + " " + clienteDTO.getDniCli() + " " + clienteDTO.getEmailCli() + " " + clienteDTO.getUsuarioCli() + " " + clienteDTO.getClaveCli());
			resultado = clienteService.registrarEmpleados(clienteDTO);
//		}

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
	
	@Test
	public void actualizarCliente_test() {
		ClienteDTO clienteDTO =new  ClienteDTO("C0001", "34563543", "Juan", "Hidalgo", "juan@gmil.com", "j1090", "clave");
		//System.out.println(clienteService.actualizarUsuario("pedro300","Torres Fuentes","Pedro89@gmail.com","pedro300","miClave").getCodCli());
	
		int resultado = clienteService.actualizarUsuario(clienteDTO);
		assertTrue(resultado == 1);
	}
}
