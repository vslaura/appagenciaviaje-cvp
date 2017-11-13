package com.cvpsa.appagenciaviajes.business.etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.cvpsa.appagenciaviajes.business.services.EmpleadoService;

public class GenerarCodigoEmpleado  extends TagSupport {
	
	public int doStartTag() throws JspException {
		try {

			JspWriter out = pageContext.getOut();
			
			EmpleadoService empleadoService = new EmpleadoService();
			String codigoEmpleado = empleadoService.obtenerCodigoAutogenerado();
			
			out.println(codigoEmpleado); 

		} catch (IOException e) {
			throw new JspException("Error: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {

		return EVAL_PAGE;
	}


}
