package com.hotel.demo.modelo;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
@Entity
@Table(name = "detalle_reserva")
public class Detalle_Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_detareser;
	private Date fecha_ingreso;
	private String hora_entrada;
	private String hora_salida;
	private Date fecha_salida;
	private int nro_reserva;
	private int nro_habi;
	
	public Detalle_Reserva() {
		super();
	}


	public Detalle_Reserva(int id_detareser, Date fecha_ingreso, String hora_entrada, String hora_salida,
			Date fecha_salida, int nro_reserva, int nro_habi) {
		super();
		this.id_detareser = id_detareser;
		this.fecha_ingreso = fecha_ingreso;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.fecha_salida = fecha_salida;
		this.nro_reserva = nro_reserva;
		this.nro_habi = nro_habi;
	}







	public int getId_detareser() {
		return id_detareser;
	}



	public void setId_detareser(int id_detareser) {
		this.id_detareser = id_detareser;
	}



	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public int getNro_reserva() {
		return nro_reserva;
	}

	public void setNro_reserva(int nro_reserva) {
		this.nro_reserva = nro_reserva;
	}
	

	
	@ManyToOne 
	  @JoinColumn(name="nro_reserva", insertable=false,updatable=false)
	  private Reserva objReserva;

	public Reserva getObjReserva() {
		return objReserva;
	}

	public void setObjReserva(Reserva objReserva) {
		this.objReserva = objReserva;
	}
	@ManyToOne
	@JoinColumn(name="nro_habi", insertable=false,updatable=false)
	private Habitacion objHabitacion;

	public int getNro_habi() {
		return nro_habi;
	}







	public void setNro_habi(int nro_habi) {
		this.nro_habi = nro_habi;
	}







	public Habitacion getObjHabitacion() {
		return objHabitacion;
	}







	public void setObjHabitacion(Habitacion objHabitacion) {
		this.objHabitacion = objHabitacion;
	}
	
}
