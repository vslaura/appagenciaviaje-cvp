package com.cvpsa.appagenciaviajes.business.etiquetas;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.cvpsa.appagenciaviajes.business.bean.CategoriaDTO;
import com.cvpsa.appagenciaviajes.business.bean.PasajeDTO;
import com.cvpsa.appagenciaviajes.business.decorator.Wrapper;
import com.cvpsa.appagenciaviajes.business.services.CategoriaService;
import com.cvpsa.appagenciaviajes.business.services.PasajeService;
import com.cvpsa.appagenciaviajes.business.servlet.ClienteServlet;
import com.cvpsa.appagenciaviajes.business.servlet.PasajeServlet;

public class AsientoReservadoTag extends TagSupport {

	public int doStartTag() throws JspException {
		try {
			
			String codigoViaje = PasajeServlet.codigoViaje;
			
			System.out.println( "Estoy en el TAG: " + codigoViaje );
			
			JspWriter out = pageContext.getOut();

			PasajeService pasajeService = new PasajeService();

			List<PasajeDTO> lista = pasajeService.listaPasajesNoReservados(codigoViaje);

			for (PasajeDTO pasajeDTO : lista) {
				out.println("<option value='" + pasajeDTO.getCodPje() + "'>" + pasajeDTO.getNroAsientoPje() + " </option>");
			}

		} catch (IOException e) {
			throw new JspException("Error: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {

		return EVAL_PAGE;
	}
	
}
