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
import com.cvpsa.appagenciaviajes.business.bean.ViajeDTO;
import com.cvpsa.appagenciaviajes.business.services.BusService;
import com.cvpsa.appagenciaviajes.business.services.DepartamentoService;
import com.cvpsa.appagenciaviajes.business.services.ViajeService;

/**
 * Servlet implementation class ViajeServlet
 */
@WebServlet("/ViajeServlet")
public class ViajeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViajeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		procesarViaje( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		procesarViaje( request, response );
	}

	private void procesarViaje(HttpServletRequest request, HttpServletResponse response) {

		String operacion = request.getParameter("operacion");
		
		switch (operacion) {
		case "listarViajesPorOrigenDestinoFecha":
			listarViajesPorOrigenDestinoFecha (request, response);
			break;

		default:
			break;
		}
		
	}

	private void listarViajesPorOrigenDestinoFecha(HttpServletRequest request, HttpServletResponse response) {

		String codigoOrigen = request.getParameter("cboDepartamentoPartida");
		String codigoDestino = request.getParameter("cboDepartamentoLlegada");
		String fecha = request.getParameter("dtFechaSalida");
		
		ViajeService viajeService = new ViajeService();
		
		List<ViajeDTO> listadoViajes = viajeService.listarViajesPorOrigenDestinoFecha(codigoOrigen, codigoDestino, fecha);
		
		DepartamentoService departamentoService = new DepartamentoService();
		
		String origen = "Origen: " + departamentoService.obtenerDescripcionDepartamento(codigoOrigen) + " ";
		String destino = "Destino: " + departamentoService.obtenerDescripcionDepartamento(codigoDestino) + " ";
		String fec = "Fecha de viaje: " + fecha;
		
		HttpSession session = request.getSession();
		session.setAttribute("listadoViajesPorOrigenDestinoFecha", listadoViajes);
		System.out.println(session.getServletContext().getContextPath());
		
		// return "<a href='Frm_Pasaje.jsp?origen=" + origen +"&&destino=" + destino +"&&fechaDestino="+fechaDestino+"'>Seleccionar</a>";
		
		try {
			request.getRequestDispatcher("/newListadoViajesCliente.jsp?origen=" + origen + "&&destino=" + destino + "&&fecha=" + fec).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
