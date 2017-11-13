package com.cvpsa.appagenciaviajes.business.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.CategoriaDTO;
import com.cvpsa.appagenciaviajes.business.services.CategoriaService;

public class CategoriaServiceTest {

	CategoriaService categoriaService = new CategoriaService();

	@Test
	public void listarCategorias_test() {

		List<CategoriaDTO> listaCategorias = categoriaService.listarCategorias();
		for (CategoriaDTO categoriaDTO : listaCategorias) {
			System.out.println(categoriaDTO.getCodCate() + " " + categoriaDTO.getTipoCate());
		}
	}

	@Test
	public void registrarCategoria_test() {

		CategoriaDTO categoriaDTO = new CategoriaDTO(3, "Azafata");

		int resultado = categoriaService.registrarCategoria(categoriaDTO);
		assertTrue(resultado == 1);
	}

}
