package com.ceiba.biblioteca.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.dto.PrestamoDTO;
import com.ceiba.biblioteca.dto.PrestamoRetornoDTO;
import com.ceiba.biblioteca.model.exepciones.BadRequestExcepcion;
import com.ceiba.biblioteca.modelo.Prestamo;

@Component
public class PrestamoFabrica {

	public Prestamo dtoModelo(PrestamoDTO prestamoDTO) throws BadRequestExcepcion{
		Prestamo prestamo = new Prestamo.PrestamoBuilder()
				.setIsbn(prestamoDTO.getIsbn())
				.setIdentificacionUsuario(prestamoDTO.getIdentificacionUsuario())
				.setTipoUsuario(prestamoDTO.getTipoUsuario())
				.setFechaPrestamo(prestamoDTO.getFechaPrestamo())
				.build();
		return prestamo;
	}
	
	public PrestamoDTO modeloDTO (Prestamo prestamoModelo) throws BadRequestExcepcion{
		PrestamoDTO prestamoDTO = new PrestamoDTO();
		prestamoDTO.setId(prestamoModelo.getId());
		prestamoDTO.setIsbn(prestamoModelo.getIsbn());
		prestamoDTO.setIdentificacionUsuario(prestamoModelo.getIdentificacionUsuario());
		prestamoDTO.setTipoUsuario(prestamoModelo.getTipoUsuario());
		prestamoDTO.setFechaMaximaDevolucion(prestamoModelo.getFechaMaximaDevolucion());
		return prestamoDTO;
	}
	
	public PrestamoRetornoDTO modeloRetornoDTO(Prestamo prestamoModelo) throws BadRequestExcepcion{
		PrestamoRetornoDTO prestamoRetorno = new PrestamoRetornoDTO();
		prestamoRetorno.setId(prestamoModelo.getId());
		prestamoRetorno.setFechaMaximaDevolucion(prestamoModelo.getFechaMaximaDevolucion());
		return prestamoRetorno;
	}
	
	
	
}
