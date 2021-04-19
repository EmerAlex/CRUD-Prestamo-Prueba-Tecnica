package com.ceiba.biblioteca.dto;

public class PrestamoDTO {
	
	private Integer id;
	private String isbn;
	private String identificacionUsuario;
	private Integer tipoUsuario;
	private String fechaMaximaDevolucion;
	
	
	public Integer getIdPrestamo() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}
	public void setIdentificacionUsuario(String identificacionUsuario) {
		this.identificacionUsuario = identificacionUsuario;
	}
	public Integer getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getFechaPrestamo() {
		return fechaMaximaDevolucion;
	}
	public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
	
	

}
