package com.cvpsa.appagenciaviajes.business.interfaces;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;

public interface ClienteDAO {

	public int registrarCliente (ClienteDTO clienteDTO);
	public int actualizarCliente (ClienteDTO clienteDTO);
	public List<ClienteDTO> listarClientes ();
	public ClienteDTO buscarCliente (String nombre, String clave);
	public ClienteDTO detalleCliente (String codigo);
	public ClienteDTO consultarCliente (String codigo);
	public int eliminarCliente (String codigo);
	
	public String obtenerCodigoAutogeneradoCliente();
	
}
