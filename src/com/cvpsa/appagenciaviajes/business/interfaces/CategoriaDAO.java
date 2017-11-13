package com.cvpsa.appagenciaviajes.business.interfaces;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.CategoriaDTO;

public interface CategoriaDAO {

	public int registrarCategoria (CategoriaDTO categoriaDTO);
	public List<CategoriaDTO> listarCategorias ();
	public List<CategoriaDTO> buscarCategoria (String codigo);
	public int eliminarCategoria (String codigo);
	public int actualizarCategoria (CategoriaDTO categoriaDTO);
}
