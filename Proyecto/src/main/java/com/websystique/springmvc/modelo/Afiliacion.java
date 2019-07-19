package com.websystique.springmvc.modelo;

import java.util.Date;

public class Afiliacion {
	
	private long idAfiliacion;
	private String nombre;
	private int estatus;
	private Date fechaCreacion;
	private int numero;
	
	public long getIdAfiliacion() {
		return idAfiliacion;
	}
	public void setIdAfiliacion(long idAfiliacion) {
		this.idAfiliacion = idAfiliacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Afiliacion [idAfiliacion=" + idAfiliacion + ", nombre="
				+ nombre + ", estatus=" + estatus + ", fechaCreacion="
				+ fechaCreacion + ", numero=" + numero + "]";
	}
	
	
}
