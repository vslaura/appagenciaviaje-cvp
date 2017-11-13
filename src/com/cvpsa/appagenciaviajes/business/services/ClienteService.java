package com.cvpsa.appagenciaviajes.business.services;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;
import com.cvpsa.appagenciaviajes.business.dao.DAOFactory;
import com.cvpsa.appagenciaviajes.business.interfaces.ClienteDAO;

public class ClienteService {

	DAOFactory factory = DAOFactory.getDAOFactory(1);
	ClienteDAO getClienteDAO = factory.getClienteDAO();
	
	public List<ClienteDTO> listarClientes(){
		return getClienteDAO.listarClientes();
	}

	public int registrarEmpleados (ClienteDTO clienteDTO){
		return getClienteDAO.registrarCliente(clienteDTO);
	}
	
	public String obtenerCodigoAutogenerado (){
		return getClienteDAO.obtenerCodigoAutogeneradoCliente();
	}
	
	public ClienteDTO buscarCliente ( String nombreUsuario, String clave ) {
		return getClienteDAO.buscarCliente(nombreUsuario, clave);
	}
}
