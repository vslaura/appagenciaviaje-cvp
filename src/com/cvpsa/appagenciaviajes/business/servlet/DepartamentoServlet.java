package com.cvpsa.appagenciaviajes.business.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.DepartamentoDTO;
import com.cvpsa.appagenciaviajes.business.services.BusService;
import com.cvpsa.appagenciaviajes.business.services.DepartamentoService;

/**
 * Servlet implementation class DepartamentoServlet
 */
@WebServlet("/DepartamentoServlet")
public class DepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarDepartamento(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		procesarDepartamento(request,response);
	}

	
	private void procesarDepartamento(HttpServletRequest request, HttpServletResponse response) {
		
		String operacion = request.getParameter("operacion");
		switch (operacion) {
		case "listarDepartamentos":
			listarDepartamentos(request, response);
			break;

		case "registrarDepartamento":
			registrarDepartamento(request, response);
			break;
		default:
			break;
		}	
}



	private void registrarDepartamento(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Registro.........");

		String codDep = request.getParameter("txtCodigoDepartamento");
		String descDep = request.getParameter("txtDescripcionDepartamento");
		
		DepartamentoDTO departamentoDTO = new DepartamentoDTO(codDep, descDep);
		
		System.out.println(departamentoDTO.toString());
		
		DepartamentoService departamentoService  = new DepartamentoService();
		
		int resultado = departamentoService.registrarDepartamento(departamentoDTO);
		
		if (resultado != 0) {
			try {
//				String msj = "Usuario o contraseña incorrecto";
//				request.getRequestDispatcher("/Frm00_Login.jsp?msj=" + msj).forward(
//						request, response);
				
				String msj = "El Departamento se ha registrado con éxito";
//				String texto = "Regresar al listado de buses";
				
				request.getRequestDispatcher("/Frm_RegistrarDepartamento.jsp?msj=" + msj)
						.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

private void listarDepartamentos(HttpServletRequest request, HttpServletResponse response) {


	DepartamentoService departamentoService = new DepartamentoService();
	List<DepartamentoDTO> listaDepartamento = departamentoService.listarDepartamentos();

	HttpSession session = request.getSession();
	session.setAttribute("listarDepartamentos", listaDepartamento);
	System.out.println(session.getServletContext().getContextPath());
	try {
		request.getRequestDispatcher("/Frm_ListadoDepartamentos.jsp").forward(request, response);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}

