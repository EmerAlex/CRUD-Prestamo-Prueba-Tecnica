package com.ceiba.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.biblioteca.model.exepciones.BadRequestExcepcion;
import com.ceiba.biblioteca.modelo.Prestamo;
import com.ceiba.biblioteca.util.Mensajes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaCrearPrestamo {

	@Rule
	public final ExpectedException excepcion = ExpectedException.none();

	@Test
	public void crearPrestamoSinIsbn() throws Exception {
		excepcion.expect(BadRequestExcepcion.class);
		excepcion.expectMessage(Mensajes.ISBN_NULO);
		Prestamo prestamo = new Prestamo.PrestamoBuilder().build();
	}

	@Test
	public void crearPrestamoConIsbnVacio() throws Exception {

		excepcion.expect(BadRequestExcepcion.class);
		excepcion.expectMessage(Mensajes.ISBN_VACIO);
		Prestamo prestamo = new Prestamo.PrestamoBuilder().setIsbn("").build();
	}
	
	@Test
	public void crearPrestamoConIsbnMaximo() throws Exception {

		excepcion.expect(BadRequestExcepcion.class);
		excepcion.expectMessage(Mensajes.ISBN_TEXTO_MAXIMO);
		Prestamo prestamo = new Prestamo.PrestamoBuilder().setIsbn("emer123aaaaaaa").build();
	}
	
	@Test
	public void crearPrestamoSinIdentificacionUsaurio() throws Exception {

		excepcion.expect(BadRequestExcepcion.class);
		excepcion.expectMessage(Mensajes.IDENTIFICACION_USUARIO_NULO);
		Prestamo prestamo = new Prestamo.PrestamoBuilder().setIsbn("1234567").build();
	}
	
	@Test
	public void crearPrestamoConIdentificacionUsaurioVacia() throws Exception {

		excepcion.expect(BadRequestExcepcion.class);
		excepcion.expectMessage(Mensajes.IDENTIFICACION_USUARIO_VACIO);
		Prestamo prestamo = new Prestamo.PrestamoBuilder().setIsbn("1234567").setIdentificacionUsuario("").build();
	}
	@Test
	public void crearPrestamoConIdentificacionUsaurioCaracteresMaximos() throws Exception {

		excepcion.expect(BadRequestExcepcion.class);
		excepcion.expectMessage(Mensajes.IDENTIFICACION_USUARIO_TEXTO_MAXIMO);
		Prestamo prestamo = new Prestamo.PrestamoBuilder().setIsbn("1234567").setIdentificacionUsuario("12345678910").build();
	}
	@Test
	public void crearPrestamoConTipoDeUsaurioNulo() throws Exception {

		excepcion.expect(BadRequestExcepcion.class);
		excepcion.expectMessage(Mensajes.TIPO_USUARIO_NULO);
		Prestamo prestamo = new Prestamo.PrestamoBuilder().setIsbn("1234567").setIdentificacionUsuario("1234567").build();
	}

	@Test
	public void crearPrestamoConTipoDeUsaurioFueraRango() throws Exception {

		excepcion.expect(BadRequestExcepcion.class);
		excepcion.expectMessage(Mensajes.TIPO_USUARIO_RANGO);
		Prestamo prestamo = new Prestamo.PrestamoBuilder().setIsbn("1234567").setIdentificacionUsuario("1234567").setTipoUsuario(0).build();
	}

	
}
