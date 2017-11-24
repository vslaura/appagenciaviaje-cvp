package com.cvpsa.appagenciaviajes.business.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;
import com.cvpsa.appagenciaviajes.business.services.ClienteService;
import com.cvpsa.appagenciaviajes.business.services.PasajeService;
import com.cvpsa.appagenciaviajes.business.utils.Mail;

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
			modificarCliente(request, response);
			break;
		case "iniciarSesion":
			iniciarSesion(request, response);
			break;
		case "recuperarPassword":
			recuperarPassword(request, response);
			break;
		case "salir":
			salir(request, response);
			break;
		default:
			break;
		}
	}

	private void recuperarPassword(HttpServletRequest request, HttpServletResponse response) {

		String correo = request.getParameter("txtCorreo");

		ClienteService clienteService = new ClienteService();
		ClienteDTO clienteDTO = clienteService.buscarClienteCorreo(correo);

		if (clienteDTO != null) {
			Mail mail = new Mail();
			mail.SendMail(correo, "Recordatorio de password - Agencia de Viajes CVP S.A", "\n" + "Estimado(a) "
					+ clienteDTO.getNomCli() + ":" + "\nSu contrase�a es: " + clienteDTO.getClaveCli());

			try {
				String msjTitulo = "Contrase�a fue enviada con �xito";
				String msjNombre = "Estimado(a) " + clienteDTO.getNomCli() + ":";
				String msjPrimeraLinea = "Se ha enviado a su correo la contrase�a";
				String msjSegundaLinea = "Por favor verifique en su bandeja de entrada, y vuelva a  iniciar sesi�n.";
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

		} else {
			try {
				String msjTitulo = "Correo Incorrecto";
				String msjNombre = "Estimado(a) " + clienteDTO.getNomCli() + ":";
				String msjPrimeraLinea = "El correo Ingresado es Incorreo ";
				String msjSegundaLinea = "Si desea recuperar su contrae�a, por favor vuelva a intentarlo";
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

	/**
	 * @param request
	 * @param response
	 */
	private void salir(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.invalidate();
		try {
			request.getRequestDispatcher("/newIndex.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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

		String codigoCliente = request.getParameter("txtCodigoCliente");
		String dniCliente = request.getParameter("txtDNI");
		String nombreCliente = request.getParameter("txtNombres");
		String apellidoCliente = request.getParameter("txtApellidos");
		String emailCliente = request.getParameter("txtEmail");
		String usuarioCliente = request.getParameter("txtUsuario");
		String claveCliente = request.getParameter("txtClave");

		HttpSession session = request.getSession();
		ClienteDTO usuarioSession = (ClienteDTO) session.getAttribute("usuarioSession");

		ClienteService clienteService = new ClienteService();
		PasajeService pasajeService = new PasajeService();

		if (usuarioSession != null) {

			System.out.println("Cliente en session");

			System.out.println("Cambiando pasaje");

			String codigoPasajeAnterior = (String) session.getAttribute("codigoPasajeSession");
			int resultadoCambio = pasajeService.deshabilitarPasajeCliente(codigoPasajeAnterior);

			int resultadoAdquirirPasaje = 0;
			
			String codigoPasaje = request.getParameter("cboAsiento");
			Date date = new Date();
			SimpleDateFormat sdfFecha = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");

			String fechaReserva = sdfFecha.format(date).toString();
			String horaReserva = sdfHora.format(date);
			
			
			if (resultadoCambio != 0) {
				System.out.println("Pasaje anterior deshabilitado");
				
				resultadoAdquirirPasaje = pasajeService.adquirirPasaje(codigoCliente, fechaReserva, horaReserva,
						codigoPasaje, "Si");
			} else {
				
				resultadoAdquirirPasaje = pasajeService.adquirirPasaje(codigoCliente, fechaReserva, horaReserva,
						codigoPasaje, "No");
			}

			if (resultadoAdquirirPasaje != 0 && resultadoCambio != 0) {

				System.out.println("Pasaje Actualizado");
				Mail mail = new Mail();
				mail.SendMail(emailCliente, "Agencia de Viajes CVP s.a", "\n" + nombreCliente + " " + apellidoCliente
						+ " - " + codigoCliente
						+ ".\n\nConfirmaci�n de Reserva.\n Estimado(a):\nSe realiz� la actualizaci�n de su Reserva de Pasaje\n su c�digo de es el "
						+ codigoPasaje + " por el monto de \nS/.45.00 - por orden de nuestro cliente " + nombreCliente
						+ " " + apellidoCliente + ". \n\nFecha y hora de la operaci�n: " + fechaReserva + " "
						+ horaReserva + ".\n\nUsted ya no puede realizar otra modificaci�n en su reserva." 
						+ "\n\nAtentamente, CVP s.a Agencia de Viajes.\n\n\n*************************** AVISO LEGAL  *************************\n\nEste mensaje es solamente para la persona a la que va dirigido.\n Puede contener informaci�n confidencial o legalmente protegida.\n No hay renunciaa la confidencialidad o privilegio por cualquier\n transmisi�n mala/err�nea.Si usted ha recibido este mensaje \npor error,le rogamos que borre de susistema inmediatamente \nel mensaje asi como todas sus copias, destruya todasde \nsu disco duro y notifique al remitente. No debe,directa o \nindirectamenteusar, revelar, distribuir, imprimir o copiar\n ninguna de las partes de este mensaje si no es\n usted el destinatario. Cualquier opini�n expresada en\n este mensaje proviene del remitente,excepto cuando el mensaje\n establezca locontrario y el remitente esta autorizado\n para establecer que dichas opiniones provienen\n de CVP s.a. N�tese que el correo electr�nico viaInternet no\n permite asegurar ni la confidencialidad de los mensajes que \nse transmiten ni la correcta recepci�n de los mismos. En \nel caso de que eldestinatario de este mensaje no consintiera \nla utilizaci�n del correo electr�nico via Internet,\nrogamos lo ponga en nuestro conocimiento de manera inmediata. ");

				try {
					String msjTitulo = "Su reserva se ha actualizado con �xito.";
					String msjNombre = "Estimado " + nombreCliente + ":";
					String msjPrimeraLinea = "El c�digo de su reserva es " + codigoPasaje
							+ ". Se ha enviado un email al correo registrado. ";
					String msjSegundaLinea = "Usted ya no puede realizar ning�n cambio en su reserva.";
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

			} else {
				
				System.out.println("Pasaje Registrado");
				Mail mail = new Mail();
				mail.SendMail(emailCliente, "Agencia de Viajes CVP s.a", "\n" + nombreCliente + " " + apellidoCliente
						+ " - " + codigoCliente
						+ ".\n\nConfirmaci�n de Reserva.\n Estimado(a):\nSe realiz� la Operaci�n Reserva de Pasaje\n su c�digo de es el "
						+ codigoPasaje + " por el monto de \nS/.45.00 - por orden de nuestro cliente " + nombreCliente
						+ " " + apellidoCliente + ". \n\nFecha y hora de la operaci�n: " + fechaReserva + " "
						+ horaReserva
						+ ". \n\nAtentamente, CVP s.a Agencia de Viajes.\n\n\n*************************** AVISO LEGAL  *************************\n\nEste mensaje es solamente para la persona a la que va dirigido.\n Puede contener informaci�n confidencial o legalmente protegida.\n No hay renunciaa la confidencialidad o privilegio por cualquier\n transmisi�n mala/err�nea.Si usted ha recibido este mensaje \npor error,le rogamos que borre de susistema inmediatamente \nel mensaje asi como todas sus copias, destruya todasde \nsu disco duro y notifique al remitente. No debe,directa o \nindirectamenteusar, revelar, distribuir, imprimir o copiar\n ninguna de las partes de este mensaje si no es\n usted el destinatario. Cualquier opini�n expresada en\n este mensaje proviene del remitente,excepto cuando el mensaje\n establezca locontrario y el remitente esta autorizado\n para establecer que dichas opiniones provienen\n de CVP s.a. N�tese que el correo electr�nico viaInternet no\n permite asegurar ni la confidencialidad de los mensajes que \nse transmiten ni la correcta recepci�n de los mismos. En \nel caso de que eldestinatario de este mensaje no consintiera \nla utilizaci�n del correo electr�nico via Internet,\nrogamos lo ponga en nuestro conocimiento de manera inmediata. ");

				try {
					String msjTitulo = "Su reserva se ha registrado con �xito.";
					String msjNombre = "Estimado " + nombreCliente + ":";
					String msjPrimeraLinea = "El c�digo de su reserva es " + codigoPasaje
							+ ". Se ha enviado un email al correo registrado. ";
					String msjSegundaLinea = "Usted cuenta con 3 d�as para realizar alg�n cambio en su reserva, si es as� inicie sesi�n.";
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
		} else {

			if ( clienteService.buscarClienteDni(dniCliente) != null ) {

				System.out.println("DNI registrado ");
				try {
					String msjTitulo = "DNI registrado.";
					String msjNombre = "Estimado(a) " + nombreCliente + ":";
					String msjPrimeraLinea = "Su DNI ya se encuentra registrado, por favor seleccione la opci�n olvid� contrase�a.";
					String msjSegundaLinea = "";
					request.getRequestDispatcher("/newResultado.jsp?msjTitulo=" + msjTitulo + "&&msjNombre="
							+ msjNombre + "&&msjPrimeraLinea=" + msjPrimeraLinea + "&&msjSegundaLinea="
							+ msjSegundaLinea).forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if ( clienteService.buscarClienteCorreo(emailCliente) != null ) {

				System.out.println("Email registrado ");
				try {
					String msjTitulo = "E-mail registrado.";
					String msjNombre = "Estimado(a) " + nombreCliente + ":";
					String msjPrimeraLinea = "Su e-mail ya se encuentra registrado, por favor verifique su correo.";
					String msjSegundaLinea = "";
					request.getRequestDispatcher("/newResultado.jsp?msjTitulo=" + msjTitulo + "&&msjNombre="
							+ msjNombre + "&&msjPrimeraLinea=" + msjPrimeraLinea + "&&msjSegundaLinea="
							+ msjSegundaLinea).forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				int resultadoRegistroCliente = 0;

				if (codigoCliente.equals("") || codigoCliente == null) {
					codigoCliente = clienteService.obtenerCodigoAutogenerado();
					ClienteDTO clienteDTO = new ClienteDTO(codigoCliente, dniCliente, nombreCliente,
							apellidoCliente, emailCliente, usuarioCliente, claveCliente);
					resultadoRegistroCliente = clienteService.registrarEmpleados(clienteDTO);

					if (resultadoRegistroCliente != 0) {
						System.out.println("Cliente registrado");
					}
				}
				
				String codigoPasaje = request.getParameter("cboAsiento");

				Date date = new Date();
				SimpleDateFormat sdfFecha = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");

				String fechaReserva = sdfFecha.format(date).toString();
				String horaReserva = sdfHora.format(date);

				int resultadoAdquirirPasaje = pasajeService.adquirirPasaje(codigoCliente, fechaReserva, horaReserva,
						codigoPasaje, "No");

				if (resultadoAdquirirPasaje != 0) {

					System.out.println("Pasaje Registrado");
					Mail mail = new Mail();
					mail.SendMail(emailCliente, "Agencia de Viajes CVP s.a", "\n" + nombreCliente + " " + apellidoCliente
							+ " - " + codigoCliente
							+ ".\n\nConfirmaci�n de Reserva.\n Estimado(a):\nSe realiz� la Operaci�n Reserva de Pasaje\n su c�digo de es el "
							+ codigoPasaje + " por el monto de \nS/.45.00 - por orden de nuestro cliente " + nombreCliente
							+ " " + apellidoCliente + ". \n\nFecha y hora de la operaci�n: " + fechaReserva + " "
							+ horaReserva
							+ ". \n\nAtentamente, CVP s.a Agencia de Viajes.\n\n\n*************************** AVISO LEGAL  *************************\n\nEste mensaje es solamente para la persona a la que va dirigido.\n Puede contener informaci�n confidencial o legalmente protegida.\n No hay renunciaa la confidencialidad o privilegio por cualquier\n transmisi�n mala/err�nea.Si usted ha recibido este mensaje \npor error,le rogamos que borre de susistema inmediatamente \nel mensaje asi como todas sus copias, destruya todasde \nsu disco duro y notifique al remitente. No debe,directa o \nindirectamenteusar, revelar, distribuir, imprimir o copiar\n ninguna de las partes de este mensaje si no es\n usted el destinatario. Cualquier opini�n expresada en\n este mensaje proviene del remitente,excepto cuando el mensaje\n establezca locontrario y el remitente esta autorizado\n para establecer que dichas opiniones provienen\n de CVP s.a. N�tese que el correo electr�nico viaInternet no\n permite asegurar ni la confidencialidad de los mensajes que \nse transmiten ni la correcta recepci�n de los mismos. En \nel caso de que eldestinatario de este mensaje no consintiera \nla utilizaci�n del correo electr�nico via Internet,\nrogamos lo ponga en nuestro conocimiento de manera inmediata. ");

					try {
						String msjTitulo = "Su reserva se ha registrado con �xito.";
						String msjNombre = "Estimado " + nombreCliente + ":";
						String msjPrimeraLinea = "El c�digo de su reserva es " + codigoPasaje
								+ ". Se ha enviado un email al correo registrado. ";
						String msjSegundaLinea = "Usted cuenta con 3 d�as para realizar alg�n cambio en su reserva, si es as� inicie sesi�n.";
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
	}

	private void listarClientes(HttpServletRequest request, HttpServletResponse response) {

		String cboEstadoBus = request.getParameter("cboEstadoBus");

		System.out.println("C�digo del estado del bus: " + cboEstadoBus);

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

	private void modificarCliente(HttpServletRequest request, HttpServletResponse response) {

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

		int resultado = clienteService.actualizarUsuario(clienteDTO);
		if (resultado != 0) {

			HttpSession sesion = request.getSession();

			sesion.setAttribute("usuarioSession", clienteDTO);

			RequestDispatcher rdispatcher = request.getRequestDispatcher("/newActualizarCliente.jsp");
			request.setAttribute("mensajeError", "Datos Incorrectos");

			try {
				rdispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				System.out.println("erros");
			}
		} else {
			RequestDispatcher rdispatcher = request.getRequestDispatcher("/newActualizarCliente.jsp");
			request.setAttribute("Exito", "Se actualizo los datos");
			try {
				rdispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				System.out.println("Error al ir a actualizar Los datos.");
			}

		}

	}

}
