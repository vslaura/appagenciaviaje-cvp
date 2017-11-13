package com.cvpsa.appagenciaviajes.business.etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.cvpsa.appagenciaviajes.business.services.BusService;

public class GenerarCodigoBus extends TagSupport {

	public int doStartTag() throws JspException {
		try {

			JspWriter out = pageContext.getOut();
			
			BusService busService = new BusService();
			String codigoBus = busService.obtenerCodigoAutogenerado();
			
			out.println(codigoBus); 

		} catch (IOException e) {
			throw new JspException("Error: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {

		return EVAL_PAGE;
	}

}
