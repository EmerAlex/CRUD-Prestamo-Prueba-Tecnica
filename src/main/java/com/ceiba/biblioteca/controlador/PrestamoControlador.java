package com.ceiba.biblioteca.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.dto.PrestamoDTO;
import com.ceiba.biblioteca.modelo.Prestamo;
import com.ceiba.biblioteca.servicio.PrestamoServicio;

@RestController
@RequestMapping("/prestamo")
public class PrestamoControlador {
	
	
	@Autowired
	private PrestamoServicio prestamoServicio;


	
	@PostMapping
	public Object registrarPrestamo(@RequestBody PrestamoDTO prestamoDTO) {
		prestamoServicio.ValidarTipoUsuario(prestamoDTO.getIdentificacionUsuario());
		return prestamoServicio.registrarPrestamo(prestamoDTO);
			
			
	}
	
	@GetMapping("/{idPrestamo}")
	public Prestamo buscarPrestamoId(@PathVariable Integer idPrestamo) {
		return (prestamoServicio.findById(idPrestamo));
	}


}
