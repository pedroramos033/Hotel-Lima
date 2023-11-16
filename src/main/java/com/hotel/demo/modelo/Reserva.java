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
@Table(name = "tb_reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nro_reserva;
	private Date fecha_reserva;
	private int cant_personas;
	private int cant_dias;
	private int nro_habi;
	private int id_huesped;
	private int id_emp;
	private int id_servicio;
	private String estado_reserva;
	
	public Reserva() {
		super();
	}

	

	public Reserva(int nro_reserva, Date fecha_reserva, int cant_personas, int cant_dias, int nro_habi, int id_huesped,
			int id_emp, int id_servicio, String estado_reserva) {
		super();
		this.nro_reserva = nro_reserva;
		this.fecha_reserva = fecha_reserva;
		this.cant_personas = cant_personas;
		this.cant_dias = cant_dias;
		this.nro_habi = nro_habi;
		this.id_huesped = id_huesped;
		this.id_emp = id_emp;
		this.id_servicio = id_servicio;
		this.estado_reserva = estado_reserva;
	}



	public int getNro_reserva() {
		return nro_reserva;
	}

	public void setNro_reserva(int nro_reserva) {
		this.nro_reserva = nro_reserva;
	}

	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public int getCant_personas() {
		return cant_personas;
	}

	public void setCant_personas(int cant_personas) {
		this.cant_personas = cant_personas;
	}

	public int getCant_dias() {
		return cant_dias;
	}

	public void setCant_dias(int cant_dias) {
		this.cant_dias = cant_dias;
	}

	public int getNro_habi() {
		return nro_habi;
	}

	public void setNro_habi(int nro_habi) {
		this.nro_habi = nro_habi;
	}

	public int getId_huesped() {
		return id_huesped;
	}

	public void setId_huesped(int id_huesped) {
		this.id_huesped = id_huesped;
	}

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	
	
	
	public String getEstado_reserva() {
		return estado_reserva;
	}



	public void setEstado_reserva(String estado_reserva) {
		this.estado_reserva = estado_reserva;
	}



	@ManyToOne
	@JoinColumn(name="nro_habi", insertable=false,updatable=false)
	private Habitacion objHabitacion;
	
	@ManyToOne
	@JoinColumn(name="id_huesped", insertable=false,updatable=false)
	private Huesped objHuesped;
	
	@ManyToOne
	@JoinColumn(name="id_emp", insertable=false,updatable=false)
	private Empleado objEmpleado;
	
	@ManyToOne
	@JoinColumn(name="id_servicio", insertable=false,updatable=false)
	private Servicio objServicio;

	public Habitacion getObjHabitacion() {
		return objHabitacion;
	}

	public void setObjHabitacion(Habitacion objHabitacion) {
		this.objHabitacion = objHabitacion;
	}

	public Huesped getObjHuesped() {
		return objHuesped;
	}

	public void setObjHuesped(Huesped objHuesped) {
		this.objHuesped = objHuesped;
	}

	public Empleado getObjEmpleado() {
		return objEmpleado;
	}

	public void setObjEmpleado(Empleado objEmpleado) {
		this.objEmpleado = objEmpleado;
	}

	public Servicio getObjServicio() {
		return objServicio;
	}

	public void setObjServicio(Servicio objServicio) {
		this.objServicio = objServicio;
	}
	
	
}
