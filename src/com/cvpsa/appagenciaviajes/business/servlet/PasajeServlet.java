package com.cvpsa.appagenciaviajes.business.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;
import com.cvpsa.appagenciaviajes.business.bean.PasajeDTO;
import com.cvpsa.appagenciaviajes.business.services.PasajeService;

/**
 * Servlet implementation class PasajeServlet
 */
@WebServlet("/PasajeServlet")
public class PasajeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String codigoViaje = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PasajeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesarPasaje(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub 
		procesarPasaje(request, response);
	}

	private void procesarPasaje(HttpServletRequest request, HttpServletResponse response) {

		String operacion = request.getParameter("operacion");
		
		HttpSession session = request.getSession();

		String codigoPasaje = (String) session.getAttribute("codigoPasajeSession");
		
		System.out.println(codigoPasaje);
		
		switch (operacion) {

		case "redireccionar":

			String origen = request.getParameter("origen");
			String destino = request.getParameter("destino");
			String fechaDestino = request.getParameter("fechaDestino");
			String codigoViaje = request.getParameter("codigoViaje");
			Double precioViaje = Double.parseDouble(request.getParameter("precioViaje"));

			PasajeServlet.codigoViaje = codigoViaje;

			try {
				request.getRequestDispatcher("/newPasaje.jsp?origen=" + origen + "&&destino=" + destino
						+ "&&fechaDestino=" + fechaDestino + "&&codigoViaje=" + codigoViaje +"&&precioViaje=" + precioViaje + "&&codigoPasaje=" + codigoPasaje).forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "listarPasajeCliente":
			listarReservaCliente(request, response);
			break;
		default:
			break;
		}

	}

	private void listarReservaCliente(HttpServletRequest request, HttpServletResponse response) {

		HttpSession httpSession = request.getSession();
		ClienteDTO cliente = (ClienteDTO) httpSession.getAttribute("usuarioSession");

		PasajeService pasajeService = new PasajeService();
		List<PasajeDTO> listarPasajeCliente = pasajeService.listarPasajeCliente(cliente.getCodCli());

		httpSession.setAttribute("listaReservas", listarPasajeCliente);

		try {
			request.getRequestDispatcher("newReservaViajesCliente.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
