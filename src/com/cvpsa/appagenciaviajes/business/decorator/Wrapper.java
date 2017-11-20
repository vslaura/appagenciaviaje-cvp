package com.cvpsa.appagenciaviajes.business.decorator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.displaytag.decorator.TableDecorator;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.DepartamentoDTO;
import com.cvpsa.appagenciaviajes.business.bean.ViajeDTO;
import com.cvpsa.appagenciaviajes.business.services.AgenciaService;
import com.cvpsa.appagenciaviajes.business.services.DepartamentoService;
import com.cvpsa.appagenciaviajes.business.services.EstadoBusService;
import com.cvpsa.appagenciaviajes.business.services.ViajeService;

public class Wrapper extends TableDecorator{

	public String getEstadoBusWrapper ( ) {
		
		// Cada fila de mi tabla, es igual a un objeto del tipo a mostrar
		BusDTO busDTO = (BusDTO) getCurrentRowObject();
		EstadoBusService estadoBusService = new EstadoBusService();
		return estadoBusService.obtenerDescripcionEstado(busDTO.getEstadoBus());
	}
	
	public String getDescripcionDepartamentoOrigenWrapper ( ) {
		
		ViajeDTO viajeDTO = (ViajeDTO) getCurrentRowObject();
		DepartamentoService departamentoService = new DepartamentoService();
		return departamentoService.obtenerDescripcionDepartamento(viajeDTO.getCodDepOrigen());
	}
	
	public String getDescripcionDepartamentoDestinoWrapper ( ) {
		
		ViajeDTO viajeDTO = (ViajeDTO) getCurrentRowObject();
		DepartamentoService departamentoService = new DepartamentoService();
		return departamentoService.obtenerDescripcionDepartamento(viajeDTO.getCodDepDestino());
	}
	
	public String getDescripcionAgenciaWrapper ( ) {
		
		ViajeDTO viajeDTO = (ViajeDTO) getCurrentRowObject();
		AgenciaService agenciaService = new AgenciaService();
		return agenciaService.obtenerDescripcionAgencia(viajeDTO.getCodigoAgencia());
	}
	
	public String getFecha_ddMMyyyy ( ) {
		
		ViajeDTO viajeDTO = (ViajeDTO) getCurrentRowObject();
		
		SimpleDateFormat sdfTexto = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
		
		Date fecha = null;
		String fec = "";
		
		try {
			fecha = sdfTexto.parse(viajeDTO.getFecPartiVje());
			fec = sdfFecha.format(fecha).toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fec;
		
	}
	
	public String getSeleccionarViajeWrapper ( ) {
		
		ViajeDTO viajeDTO = (ViajeDTO) getCurrentRowObject();
		DepartamentoService departamentoService = new DepartamentoService();
		String origen = departamentoService.obtenerDescripcionDepartamento(viajeDTO.getCodDepOrigen());
		String destino = departamentoService.obtenerDescripcionDepartamento(viajeDTO.getCodDepDestino());
		String fechaDestino = viajeDTO.getFecPartiVje();
		String codigoViaje = viajeDTO.getCodVje();
		Double precioViaje = viajeDTO.getPrecioViaje();

		return "<a href='PasajeServlet?operacion=redireccionar&&origen=" + origen +"&&destino=" + destino +"&&fechaDestino=" + fechaDestino + "&&codigoViaje=" + codigoViaje +"&&precioViaje=" + precioViaje +"'>Seleccionar</a>";
	}
	
	
	public String getSeleccionarPasajeWrapper ( ) {
		
		ViajeDTO viajeDTO = (ViajeDTO) getCurrentRowObject();
		DepartamentoService departamentoService = new DepartamentoService();
		String origen = departamentoService.obtenerDescripcionDepartamento(viajeDTO.getCodDepOrigen());
		String destino = departamentoService.obtenerDescripcionDepartamento(viajeDTO.getCodDepDestino());
		String fechaDestino = viajeDTO.getFecPartiVje();
		String codigoViaje = viajeDTO.getCodVje();

		return "<a href='newActualizarPasaje.jsp?origen=" + origen +"&&destino=" + destino +"&&fechaDestino=" + fechaDestino + "&&codigoViaje=" + codigoViaje +"'>Seleccionar</a>";
	}
	
}
