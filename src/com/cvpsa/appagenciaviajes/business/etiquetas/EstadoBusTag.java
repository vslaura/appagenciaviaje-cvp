package com.cvpsa.appagenciaviajes.business.etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.cvpsa.appagenciaviajes.business.bean.EstadoBusDTO;
import com.cvpsa.appagenciaviajes.business.services.EstadoBusService;

public class EstadoBusTag extends TagSupport {

	public int doStartTag() throws JspException {
		try {

			JspWriter out = pageContext.getOut();

			EstadoBusService servicio = new EstadoBusService();

			List<EstadoBusDTO> lista = servicio.listarEstadoBuses(); 

			for (EstadoBusDTO estadoBusDTO : lista) {
				out.println("<option value='" + estadoBusDTO.getCodigoEstadoBus() + "'>" + estadoBusDTO.getDescEstadoBus() + " </option>");
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
