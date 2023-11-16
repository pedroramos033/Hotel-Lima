package com.hotel.demo.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
@Entity
@Table(name = "tb_habitacion")
public class Habitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nro_habi;
	private String descripcion;
	private String estado;
	private int precio_habi;
	
	public Habitacion() {
		super();
	}

	

	public Habitacion(int nro_habi, String descripcion, String estado, int precio_habi) {
		super();
		this.nro_habi = nro_habi;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precio_habi = precio_habi;
	}



	public int getNro_habi() {
		return nro_habi;
	}

	public void setNro_habi(int nro_habi) {
		this.nro_habi = nro_habi;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	public int getPrecio_habi() {
		return precio_habi;
	}



	public void setPrecio_habi(int precio_habi) {
		this.precio_habi = precio_habi;
	}
	
	
}
