package com.ceiba.biblioteca.util;

import java.util.Date;

import com.ceiba.biblioteca.model.exepciones.BadRequestExcepcion;

public class Validador {


	
	public static void objetoNulo(Object objeto, String mensaje) throws BadRequestExcepcion {
		if (objeto == null) {
			throw new BadRequestExcepcion(mensaje);
		}
	}

	public static void textoVacio(String texto, String mensaje) throws BadRequestExcepcion {
		if (texto.trim() == "") {
			throw new BadRequestExcepcion(mensaje);
		}
	}

	public static void textoNulo(String texto, String mensaje) throws BadRequestExcepcion {
		if (texto==(null)) {
			throw new BadRequestExcepcion(mensaje);
		}
	}

	public static void numeroCero(Integer numero, String mensaje) throws BadRequestExcepcion {
		if (numero == 0) {
			throw new BadRequestExcepcion(mensaje);
		}
	}

	public static void numeroNulo(Integer numero, String mensaje) throws BadRequestExcepcion {
		if (numero == null) {
			throw new BadRequestExcepcion(mensaje);
		}
	}

	public static void textoMaximo(String texto, String mensaje) throws BadRequestExcepcion {
		if (texto.toCharArray().length > 10) {
			throw new BadRequestExcepcion(mensaje);
		}
	}

	public static void rangoTipoUsuario(Integer numero, String mensaje) throws BadRequestExcepcion {
		if (numero != 1 && numero != 2 && numero != 3) {
			throw new BadRequestExcepcion(mensaje);
		}
	}

	public static void fechaNula(Date fecha, String mensaje) throws BadRequestExcepcion {
		if (fecha == null) {
			throw new BadRequestExcepcion(mensaje);
		}
	}

	
}
