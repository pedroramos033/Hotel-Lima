package com.hotel.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_pago")
public class Registro_Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pago;
	private int nro_reserva;
	private double precio;
	private int cant_dias;
	private int precio_habi;
	private double monto;

	
	public Registro_Pago() {

	}
	
	
	
	public Registro_Pago(int id_pago, int nro_reserva, int precio, int cant_dias, int precio_habi, double monto) {
		super();
		this.id_pago = id_pago;
		this.nro_reserva = nro_reserva;
		this.precio = precio;
		this.cant_dias = cant_dias;
		this.precio_habi = precio_habi;
		this.monto = monto;
	}



	@ManyToOne
	  @JoinColumn(name="nro_reserva", insertable=false,updatable=false)
	  private Reserva objReserva;

	  @ManyToOne
		@JoinColumn(name="id_servicio", insertable=false,updatable=false)
		private Servicio objServicio;
	  
	  @ManyToOne
		@JoinColumn(name="nro_habi", insertable=false,updatable=false)
		private Habitacion objHabitacion;
	
	
	public int getId_pago() {
		return id_pago;
	}
	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}
	
	
	
	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public int getPrecio_habi() {
		return precio_habi;
	}
	public void setPrecio_habi(int precio_habi) {
		this.precio_habi = precio_habi;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	public int getCant_dias() {
		return cant_dias;
	}



	public void setCant_dias(int cant_dias) {
		this.cant_dias = cant_dias;
	}



	public int getNro_reserva() {
		return nro_reserva;
	}
	public void setNro_reserva(int nro_reserva) {
		this.nro_reserva = nro_reserva;
	}
	public Reserva getObjReserva() {
		return objReserva;
	}
	public void setObjReserva(Reserva objReserva) {
		this.objReserva = objReserva;
	}
	public Servicio getObjServicio() {
		return objServicio;
	}
	public void setObjServicio(Servicio objServicio) {
		this.objServicio = objServicio;
	}
	public Habitacion getObjHabitacion() {
		return objHabitacion;
	}
	public void setObjHabitacion(Habitacion objHabitacion) {
		this.objHabitacion = objHabitacion;
	}
	

	
}
