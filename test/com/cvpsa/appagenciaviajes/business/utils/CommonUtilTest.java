package com.cvpsa.appagenciaviajes.business.utils;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class CommonUtilTest {

	CommonUtil commonUtil = new CommonUtil();
	
	@Test
	public void convertirFecha_test() {

		String fecha = commonUtil.convertirFechaFormato_DD_MM_YYYY(new Date());
		System.out.println(fecha);
	
	}
	
	@Test
	public void convertirStringFecha_DD_MM_YYYY_test(){
		String fecha = commonUtil.convertirStringFecha_DD_MM_YYYY("2017-12-10");
		System.out.println(fecha);
	}

}
