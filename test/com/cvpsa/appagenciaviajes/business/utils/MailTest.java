package com.cvpsa.appagenciaviajes.business.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;
import com.cvpsa.appagenciaviajes.business.services.ClienteService;

public class MailTest {
	
	Mail mail = new Mail();

	@Test
	public void test() {
		
		mail.SendMail("lcvaldiviasanchez@gmail.com", "Agencia de Viajes CVP s.a", "\nLAURA VALDIVIA SÁNCHEZ- C0001.\n\nConfirmación de Reserva.\n Estimado(a):\nSe realizó la Operación Reserva de Pasaje\n su código de es el P0001 por el monto de \nS/.45.00 - por orden de nuestro cliente (Nombre y apellido). \n\nFecha y hora de la operación:(fecha). \n\nAtentamente, CVP s.a Agencia de Viajes.\n\n\n*************************** AVISO LEGAL  *************************\n\nEste mensaje es solamente para la persona a la que va dirigido.\n Puede contener información confidencial o legalmente protegida.\n No hay renunciaa la confidencialidad o privilegio por cualquier\n transmisión mala/errónea.Si usted ha recibido este mensaje \npor error,le rogamos que borre de susistema inmediatamente \nel mensaje asi como todas sus copias, destruya todasde \nsu disco duro y notifique al remitente. No debe,directa o \nindirectamenteusar, revelar, distribuir, imprimir o copiar\n ninguna de las partes de este mensaje si no es\n usted el destinatario. Cualquier opinión expresada en\n este mensaje proviene del remitente,excepto cuando el mensaje\n establezca locontrario y el remitente esta autorizado\n para establecer que dichas opiniones provienen\n de CVP s.a. Nótese que el correo electrónico viaInternet no\n permite asegurar ni la confidencialidad de los mensajes que \nse transmiten ni la correcta recepción de los mismos. En \nel caso de que eldestinatario de este mensaje no consintiera \nla utilización del correo electrónico via Internet,\nrogamos lo ponga en nuestro conocimiento de manera inmediata. ");
	}

	
	@Test
	public void test_recuperarPassword() {
		String correo = null;
		ClienteService clienteService = new ClienteService();
		ClienteDTO clienteDTO = clienteService.buscarClienteCorreo(correo);
	
		mail.SendMail("lcvaldiviasanchez@gmail.com","Recuperacion de contraseña - Agencia de Viajes CVP s.a","Estimado(a) LAURA VALDIVIA SÁNCHEZ- C0001:\n\nSu contraseña es : 1234");
		}
}
