package com.ceiba.biblioteca.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalcularFechaMaxima {

	

	static SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

	public static String fechaMaxima(Integer tipoUsuario) {
		int dias = 0;
		Calendar fechaActual = Calendar.getInstance();
		switch (tipoUsuario) {
		case 1:
			dias = 10;
			break;
		case 2:
			dias = 8;
			break;
		case 3:
			dias = 7;
			break;

		default:
			break;
		}
		int iterador = 1;
		while (iterador < dias) {
			
			if(fechaActual.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY && 
					fechaActual.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY ) {
				iterador ++;
			}
			
			fechaActual.add(Calendar.DATE, 1);
		}

		return formatoFecha.format(fechaActual.getTime());

	}

}
