package com.cvpsa.appagenciaviajes.business.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cvpsa.appagenciaviajes.business.bean.DepartamentoDTO;
import com.cvpsa.appagenciaviajes.business.bean.EmpleadoDTO;
import com.cvpsa.appagenciaviajes.business.services.DepartamentoService;
import com.cvpsa.appagenciaviajes.business.services.EmpleadoService;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarEmpleado ( request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarEmpleado ( request, response);
	}
	private void procesarEmpleado(HttpServletRequest request, HttpServletResponse response) {

	
		String operacion = request.getParameter("operacion");
		switch (operacion) {
		case "registarEmpleado":
			registarEmpleado(request, response);
			break;

		case "listarEmpleado":
			listarEmpleado(request, response);
			break;
		default:
			break;
		}	
	}
	private void registarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Registro.........");
		
				String codEmp = request.getParameter("txtCodigoEmple");
				String dniEmp = request.getParameter("txtDniEmple");
				String nomEmp = request.getParameter("txtNombreEmple");
				String apellEmp = request.getParameter("txtApellidosEmple");
				Integer categoria = Integer.parseInt(request.getParameter("txtTipoEmpleado"));
			
				
				EmpleadoDTO empleadoDTO = new EmpleadoDTO(codEmp, dniEmp, nomEmp, apellEmp, categoria);
				
				System.out.println(empleadoDTO.toString());
				
				EmpleadoService empleadoService  = new EmpleadoService();

				int resultado = empleadoService.registrarEmpleados(empleadoDTO);
				if (resultado != 0) {
					try {
						String msj = "El Cliente se ha registrado con éxito";
						request.getRequestDispatcher("/Frm_Resultado.jsp?msj=" + msj)
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

			private void listarEmpleado(HttpServletRequest request, HttpServletResponse response) {


				EmpleadoService empleadoService = new EmpleadoService();
				List<EmpleadoDTO> listadoEmpleados = empleadoService.listarEmpleados();

				HttpSession session = request.getSession();
				session.setAttribute("listaEmpleados", listadoEmpleados);
				System.out.println(session.getServletContext().getContextPath());
				try {
					request.getRequestDispatcher("/Frm_ListadoEmpleado.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
