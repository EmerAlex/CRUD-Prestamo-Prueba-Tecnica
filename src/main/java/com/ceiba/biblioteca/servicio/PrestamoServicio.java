package com.ceiba.biblioteca.servicio;

import java.util.List;

import com.ceiba.biblioteca.dto.PrestamoDTO;
import com.ceiba.biblioteca.dto.PrestamoRetornoDTO;
import com.ceiba.biblioteca.modelo.Prestamo;


public interface PrestamoServicio {
	
	PrestamoRetornoDTO registrarPrestamo(PrestamoDTO prestamoDto);
	
	Prestamo findById(Integer idPrestamo);

	List<Prestamo> findByIdentificacionUsuario (String identificacionUsuario);
	
	boolean ValidarTipoUsuario(String identificacionUsuario);
	

	
}
