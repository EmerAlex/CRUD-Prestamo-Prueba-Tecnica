package com.ceiba.biblioteca.persistencia;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.modelo.Prestamo;

@Repository
public interface PrestamoRepositorio extends CrudRepository<Prestamo, Integer> {
	
	
	List<Prestamo> findByIdentificacionUsuario(String identificacionUsuario);
}
