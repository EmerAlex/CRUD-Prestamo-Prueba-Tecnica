package com.ceiba.biblioteca.util.excepciones;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ceiba.biblioteca.model.exepciones.BadRequestExcepcion;

@ControllerAdvice
public class GuiaExcepciones {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({
		
		BadRequestExcepcion.class,
		org.springframework.web.HttpRequestMethodNotSupportedException.class
		
	})
	@ResponseBody
	public MensajeError badRequest(HttpServletRequest request, Exception excepcion) {
		return new MensajeError(excepcion,request.getRequestURI());
	}

}
