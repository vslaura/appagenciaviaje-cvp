package com.cvpsa.appagenciaviajes.business.services;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.CategoriaDTO;
import com.cvpsa.appagenciaviajes.business.dao.DAOFactory;
import com.cvpsa.appagenciaviajes.business.interfaces.CategoriaDAO;

public class CategoriaService {

	DAOFactory factory = DAOFactory.getDAOFactory(1);
	CategoriaDAO getCategoriaDAO = factory.getCategoriaDAO();
	
	public List<CategoriaDTO> listarCategorias (){
		return getCategoriaDAO.listarCategorias();
	}

	public int registrarCategoria (CategoriaDTO categoriaDTO){
		return getCategoriaDAO.registrarCategoria(categoriaDTO);
	}
}
