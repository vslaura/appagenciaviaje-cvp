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
import com.cvpsa.appagenciaviajes.business.services.BusService;

/**
 * Servlet implementation class Frm_Bus
 */
@WebServlet("/BusServlet")
public class BusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BusServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		procesarBuses(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		procesarBuses(request, response);
	}

	private void procesarBuses(HttpServletRequest request, HttpServletResponse response) {

		String operacion = request.getParameter("operacion");

		switch (operacion) {
		case "listarBuses":
			listarBuses(request, response);
			break;

		case "registrarBuses":
			registrarBus(request, response);
			break;
		default:
			break;
		}

	}

	private void registrarBus(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Registro.........");
		
		String codigoBus = request.getParameter("txtCodigo");
		String placaBus = request.getParameter("txtPlaca");
		String colorBus = request.getParameter("txtColor");
		String marcaBus = request.getParameter("txtMarca");
		Integer cantidadAsientosBus = Integer.parseInt(request.getParameter("txtCantidadAsientosBus"));
		String estadoBus = request.getParameter("cboEstadoBus");
		
		BusDTO busDTO = new BusDTO(codigoBus, placaBus, colorBus, marcaBus, cantidadAsientosBus, estadoBus);
		
		System.out.println(busDTO.toString());
		
		BusService busService  = new BusService();
		
//		String operacion = "/appagenciaviajes-cvp/BusServlet?operacion=listarBuses";
//		String estado = "EB000";
//		System.out.println(operacion);
		
		int resultado = busService.registrarBus(busDTO);
		
		if (resultado != 0) {
			try {
				String msj = "El bus se ha registrado con éxito";
//				String texto = "Regresar al listado de buses";
				
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

	private void listarBuses(HttpServletRequest request, HttpServletResponse response) {

		String cboEstadoBus = request.getParameter("cboEstadoBus");

		System.out.println("Código del estado del bus: " + cboEstadoBus);

		BusService busService = new BusService();
		List<BusDTO> listadoBus = busService.listarBuses(cboEstadoBus);

		HttpSession session = request.getSession();
		session.setAttribute("listadoBuses", listadoBus);
		System.out.println(session.getServletContext().getContextPath());
		try {
			request.getRequestDispatcher("/Frm_ListadoBuses.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
