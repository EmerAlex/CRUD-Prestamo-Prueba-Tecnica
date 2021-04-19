package com.ceiba.biblioteca.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.biblioteca.dto.PrestamoDTO;
import com.ceiba.biblioteca.dto.PrestamoRetornoDTO;
import com.ceiba.biblioteca.fabrica.PrestamoFabrica;
import com.ceiba.biblioteca.model.exepciones.BadRequestExcepcion;
import com.ceiba.biblioteca.modelo.Prestamo;
import com.ceiba.biblioteca.persistencia.PrestamoRepositorio;
import com.ceiba.biblioteca.servicio.PrestamoServicio;


@Service
public class PrestamoServicioImplementacion implements PrestamoServicio{

	
	@Autowired
	private PrestamoRepositorio prestamoRepositorio;
	
	@Autowired
	private PrestamoFabrica prestamoFabrica;
	
	

	@Override
	public PrestamoRetornoDTO registrarPrestamo(PrestamoDTO prestamoDTO)  {
		Prestamo prestamo = prestamoFabrica.dtoModelo(prestamoDTO);
		prestamoRepositorio.save(prestamo);
		return prestamoFabrica.modeloRetornoDTO(prestamo) ;
	}

	@Override
	public Prestamo findById(Integer idPrestamo) {
		return prestamoRepositorio.findById(idPrestamo).orElse(null);
	}

	@Override
	public List<Prestamo> findByIdentificacionUsuario(String identificacionUsuario) {
		return prestamoRepositorio.findByIdentificacionUsuario(identificacionUsuario);
	}
	
	@Override
	public  boolean ValidarTipoUsuario(String identificacionUsuario) throws BadRequestExcepcion{
		boolean retorno = false;

		List<Prestamo> prestamos = findByIdentificacionUsuario(identificacionUsuario); 
		if(prestamos==null) {
			retorno =false;
		}else {
			for (Prestamo prestamo : prestamos) {
				if(prestamo.getTipoUsuario()==3) {
					retorno=true;
					throw new BadRequestExcepcion("El usuario con identificacion " +identificacionUsuario + " ya tiene un libro prestado por lo cual no se le puede realizar otro prestamo");
				}
			}
		}
		return retorno;
	}





}
