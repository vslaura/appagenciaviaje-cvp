package com.cvpsa.appagenciaviajes.business.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	public String convertirFechaFormato_DD_MM_YYYY ( Date date ) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String fecha = sdf.format(date).toString();
		
		return fecha;
	}
	
	public String convertirStringFecha_DD_MM_YYYY ( String fecha ) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			Date date= simpleDateFormat.parse(fecha);
			simpleDateFormat1.format(date).toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fecha;
		
	}
	
}
