package com.cvpsa.appagenciaviajes.business.etiquetas;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.cvpsa.appagenciaviajes.business.bean.DepartamentoDTO;

import com.cvpsa.appagenciaviajes.business.services.DepartamentoService;


public class DepartamentoTag   extends TagSupport{
	
	public int doStartTag() throws JspException {
		try {

			JspWriter out = pageContext.getOut();

			DepartamentoService servicio = new DepartamentoService();

			List<DepartamentoDTO> lista = servicio.listarDepartamentos();

			for (DepartamentoDTO departamentoDTO : lista) {
				out.println("<option value='" + departamentoDTO.getCodDep() + "'>" + departamentoDTO.getDescDep() + " </option>");
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
