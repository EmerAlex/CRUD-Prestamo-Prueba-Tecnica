package com.ceiba.biblioteca.modelo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ceiba.biblioteca.model.exepciones.BadRequestExcepcion;
import com.ceiba.biblioteca.util.CalcularFechaMaxima;
import com.ceiba.biblioteca.util.Mensajes;
import com.ceiba.biblioteca.util.Validador;

@Entity
@Table (name="prestamo")
public class Prestamo {

	@Id
	@GeneratedValue
	@Column (name="id")
	private Integer id;
	
	@Column (name = "isbn")
	private String isbn;
	
	@Column (name= "identificacionusuario")
	private String identificacionUsuario;
	
	@Column (name = "tipousaurio")
	private Integer tipoUsuario;
	
	@Column (name = "fechamaximadevolucion")
	private String fechaMaximaDevolucion;
	
	private  Prestamo() {
		
		super();
		
	}
	
	public static class PrestamoBuilder{
		
		private String isbn;
		private String identificacionUsuario;
		private Integer tipoUsuario;
		private String fechaMaximaDevolucion;
		
		

		
		public PrestamoBuilder setIsbn(String isbn) {
			this.isbn = isbn;
			return this;
		}
		public PrestamoBuilder setIdentificacionUsuario(String identificacionUsuario) {
			this.identificacionUsuario = identificacionUsuario;
			return this;
		}
		public PrestamoBuilder setTipoUsuario(Integer tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
			return this;
		}
		public PrestamoBuilder setFechaPrestamo(String fechaMaximaDevolucion) {
			this.fechaMaximaDevolucion = fechaMaximaDevolucion;
			return this;
		}
		
		public Prestamo build() throws BadRequestExcepcion{
			Prestamo prestamo = new Prestamo();
	
			
			Validador.textoNulo(isbn, Mensajes.ISBN_NULO);
			Validador.textoVacio(isbn, Mensajes.ISBN_VACIO);
			Validador.textoMaximo(isbn, Mensajes.ISBN_TEXTO_MAXIMO);
			prestamo.isbn=isbn;
			
			Validador.textoNulo(identificacionUsuario, Mensajes.IDENTIFICACION_USUARIO_NULO);
			Validador.textoVacio(identificacionUsuario, Mensajes.IDENTIFICACION_USUARIO_VACIO);
			Validador.textoMaximo(identificacionUsuario, Mensajes.IDENTIFICACION_USUARIO_TEXTO_MAXIMO);
			prestamo.identificacionUsuario=identificacionUsuario;
			
			Validador.numeroNulo(tipoUsuario, Mensajes.TIPO_USUARIO_NULO);
			Validador.rangoTipoUsuario(tipoUsuario, Mensajes.TIPO_USUARIO_RANGO);
			prestamo.tipoUsuario=tipoUsuario;
			
		
			prestamo.fechaMaximaDevolucion=CalcularFechaMaxima.fechaMaxima(tipoUsuario);
			
			return prestamo;
			
		}
		
	}

	public Integer getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public String getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}
	
	
	

}
