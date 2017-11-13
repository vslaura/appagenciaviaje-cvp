package com.cvpsa.appagenciaviajes.business.interfaces;

import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.AgenciaDTO;

public interface AgenciaDAO {

	public List<AgenciaDTO> listarAgencias ( );
	public int registrarAgencia ( AgenciaDTO agenciaDTO );
	public String obtenerDescripcionAgencia ( String codigoAgencia );
}
