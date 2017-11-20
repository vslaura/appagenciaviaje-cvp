package com.cvpsa.appagenciaviajes.business.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;
import com.cvpsa.appagenciaviajes.business.services.ClienteService;

public class MailTest {
	
	Mail mail = new Mail();

	@Test
	public void test() {
		
		mail.SendMail("lcvaldiviasanchez@gmail.com", "Agencia de Viajes CVP s.a", "\nLAURA VALDIVIA S�NCHEZ- C0001.\n\nConfirmaci�n de Reserva.\n Estimado(a):\nSe realiz� la Operaci�n Reserva de Pasaje\n su c�digo de es el P0001 por el monto de \nS/.45.00 - por orden de nuestro cliente (Nombre y apellido). \n\nFecha y hora de la operaci�n:(fecha). \n\nAtentamente, CVP s.a Agencia de Viajes.\n\n\n*************************** AVISO LEGAL  *************************\n\nEste mensaje es solamente para la persona a la que va dirigido.\n Puede contener informaci�n confidencial o legalmente protegida.\n No hay renunciaa la confidencialidad o privilegio por cualquier\n transmisi�n mala/err�nea.Si usted ha recibido este mensaje \npor error,le rogamos que borre de susistema inmediatamente \nel mensaje asi como todas sus copias, destruya todasde \nsu disco duro y notifique al remitente. No debe,directa o \nindirectamenteusar, revelar, distribuir, imprimir o copiar\n ninguna de las partes de este mensaje si no es\n usted el destinatario. Cualquier opini�n expresada en\n este mensaje proviene del remitente,excepto cuando el mensaje\n establezca locontrario y el remitente esta autorizado\n para establecer que dichas opiniones provienen\n de CVP s.a. N�tese que el correo electr�nico viaInternet no\n permite asegurar ni la confidencialidad de los mensajes que \nse transmiten ni la correcta recepci�n de los mismos. En \nel caso de que eldestinatario de este mensaje no consintiera \nla utilizaci�n del correo electr�nico via Internet,\nrogamos lo ponga en nuestro conocimiento de manera inmediata. ");
	}

	
	@Test
	public void test_recuperarPassword() {
		String correo = null;
		ClienteService clienteService = new ClienteService();
		ClienteDTO clienteDTO = clienteService.buscarClienteCorreo(correo);
	
		mail.SendMail("lcvaldiviasanchez@gmail.com","Recuperacion de contrase�a - Agencia de Viajes CVP s.a","Estimado(a) LAURA VALDIVIA S�NCHEZ- C0001:\n\nSu contrase�a es : 1234");
		}
}
