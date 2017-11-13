package com.cvpsa.appagenciaviajes.business.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;
import com.cvpsa.appagenciaviajes.business.bean.PasajeDTO;
import com.cvpsa.appagenciaviajes.business.services.ClienteService;
import com.cvpsa.appagenciaviajes.business.services.PasajeService;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		procesarCliente(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		procesarCliente(request, response);

	}

	private void procesarCliente(HttpServletRequest request, HttpServletResponse response) {

		String operacion = request.getParameter("operacion");

		switch (operacion) {
		case "listarClientes":
			listarClientes(request, response);
			break;
		case "registrarCliente":
			registarCliente(request, response);
			break;
		case "modificarCliente":
			break;
		case "iniciarSesion":
			iniciarSesion(request, response);
			break;
		default:
			break;
		}
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) {

		String nombreUsuario = request.getParameter("txtUsuario");
		String claveUsuario = request.getParameter("txtClave");

		ClienteService clienteService = new ClienteService();

		ClienteDTO clienteDTO = clienteService.buscarCliente(nombreUsuario, claveUsuario);

		if (clienteDTO != null) {

			HttpSession sesion = request.getSession();
			
			sesion.setAttribute("usuarioSession", clienteDTO);
			
			try {
				request.getRequestDispatcher("/newIndex.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {

			String resultado = "Usuario o clave incorrecto.";
			try {
				request.getRequestDispatcher("/newLogin.jsp?resultado=" + resultado).forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	private void registarCliente(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Registro.........");

		String codCli = request.getParameter("txtCodigoCliente");
		String dniCli = request.getParameter("txtDNI");
		String nomCli = request.getParameter("txtNombres");
		String apeCli = request.getParameter("txtApellidos");
		String emailCli = request.getParameter("txtEmail");
		String usuCli = request.getParameter("txtUsuario");
		String claveCli = request.getParameter("txtClave");

		ClienteDTO clienteDTO = new ClienteDTO(codCli, dniCli, nomCli, apeCli, emailCli, usuCli, claveCli);

		System.out.println(clienteDTO.toString());

		ClienteService clienteService = new ClienteService();

		int resultado = clienteService.registrarEmpleados(clienteDTO);
		if (resultado != 0) {

			System.out.println("Cliente registrado");

			int nroAsiento = Integer.parseInt(request.getParameter("cboAsiento"));
			double precio = Double.parseDouble(request.getParameter("txtPrecio"));
			String codigoViaje = request.getParameter("txtCodigoViaje");

			// Quizas colocar la hora de compra

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String fechaCompra = sdf.format(date).toString();

			PasajeService pasajeService = new PasajeService();

			String codigoPasaje = pasajeService.generarCodigoPasaje();

			PasajeDTO pasajeDTO = new PasajeDTO(codigoPasaje, nroAsiento, precio, fechaCompra, codCli, codigoViaje);

			int resultadoViaje = pasajeService.registrarPasaje(pasajeDTO);

			if (resultadoViaje != 0) {
				System.out.println("Pasaje Registrado");

				try {
					String msjTitulo = "Su reserva se ha registrado con éxito.";
					String msjNombre = "Estimado " + nomCli + ":";
					String msjPrimeraLinea = "El código de su reserva es " + codigoPasaje
							+ ". Se ha enviado un email al correo registrado. ";
					String msjSegundaLinea = "Si desea realizar algún cambio en su reserva, por favor inicie sesión.";
					request.getRequestDispatcher("/newResultado.jsp?msjTitulo=" + msjTitulo + "&&msjNombre=" + msjNombre
							+ "&&msjPrimeraLinea=" + msjPrimeraLinea + "&&msjSegundaLinea=" + msjSegundaLinea)
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

	}

	private void listarClientes(HttpServletRequest request, HttpServletResponse response) {

		String cboEstadoBus = request.getParameter("cboEstadoBus");

		System.out.println("Código del estado del bus: " + cboEstadoBus);

		ClienteService clienteService = new ClienteService();
		List<ClienteDTO> listadoCliente = clienteService.listarClientes();

		HttpSession session = request.getSession();
		session.setAttribute("listaClientes", listadoCliente);
		System.out.println(session.getServletContext().getContextPath());
		try {
			request.getRequestDispatcher("/Frm_ListadoClientes.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
