package com.websystique.springmvc.modelo;



public class AfiliacionBO {
	
	private long idAfiliacion;
	private String nombre;
	private int estatus;
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
		return "AfiliacionBO [idAfiliacion=" + idAfiliacion + ", nombre="
				+ nombre + ", estatus=" + estatus + ", numero=" + numero + "]";
	}
	
	
	
	
}
