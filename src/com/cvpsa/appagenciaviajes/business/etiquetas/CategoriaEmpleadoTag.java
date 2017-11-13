package com.cvpsa.appagenciaviajes.business.etiquetas;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.cvpsa.appagenciaviajes.business.bean.CategoriaDTO;
import com.cvpsa.appagenciaviajes.business.services.CategoriaService;

public class CategoriaEmpleadoTag   extends TagSupport{
	
	public int doStartTag() throws JspException {
		try {

			JspWriter out = pageContext.getOut();

			CategoriaService categoriaService = new CategoriaService();

			List<CategoriaDTO> lista = categoriaService.listarCategorias();

			for (CategoriaDTO categoriaDTO : lista) {
				out.println("<option value='" + categoriaDTO.getCodCate() + "'>" + categoriaDTO.getTipoCate() + " </option>");
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
