package com.cvpsa.appagenciaviajes.business.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class MailTest {
	
	Mail mail = new Mail();

	@Test
	public void test() {
		
		mail.SendMail("lcvaldiviasanchez@gmail.com", "4m0r", "3e505");
	}

}
