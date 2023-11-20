
  package com.hotel.demo.modelo; import java.sql.Time;
  
  import jakarta.persistence.Entity; import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
  import jakarta.persistence.JoinColumn; import jakarta.persistence.ManyToOne;
  import jakarta.persistence.Table;
  
  @Entity
  
  @Table(name = "detalle_servicio")
  public class Detalle_Servicio {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_detaserv;
  private int id_servicio;
  private Time hora_serv; 
  private String estado_serv; 
  private int nro_reserva;
  private int id_emp;
  
  public Detalle_Servicio() { super(); }
  
  
  
  public Detalle_Servicio(int id_detaserv, int id_servicio, Time hora_serv, String estado_serv, int nro_reserva,
		int id_emp) {
	super();
	this.id_detaserv = id_detaserv;
	this.id_servicio = id_servicio;
	this.hora_serv = hora_serv;
	this.estado_serv = estado_serv;
	this.nro_reserva = nro_reserva;
	this.id_emp = id_emp;
}



public int getId_detaserv() { return id_detaserv; }
  
  public void setId_detaserv(int id_detaserv) { this.id_detaserv = id_detaserv;
  }
  
  public Time getHora_serv() { return hora_serv; }
  
  public void setHora_serv(Time hora_serv) { this.hora_serv = hora_serv; }
  
  public String getEstado_serv() { return estado_serv; }
  
  public void setEstado_serv(String estado_serv) { this.estado_serv =
  estado_serv; }
  
  public int getNro_reserva() { return nro_reserva; }
  
  public void setNro_reserva(int nro_reserva) { this.nro_reserva = nro_reserva;
  }
  
  public int getId_emp() { return id_emp; }
  
  public void setId_emp(int id_emp) { this.id_emp = id_emp; }
  
  public int getId_servicio() {
	return id_servicio;
}

public void setId_servicio(int id_servicio) {
	this.id_servicio = id_servicio;
}

@ManyToOne 
  @JoinColumn(name="nro_reserva", insertable=false,updatable=false)
  private Reserva objReserva;
  
  
  @ManyToOne
  @JoinColumn(name="id_emp", insertable=false,updatable=false) 
  private Empleado objEmpleado;
  
  @ManyToOne
	@JoinColumn(name="id_servicio", insertable=false,updatable=false)
	private Servicio objServicio;

public Reserva getObjReserva() {
	return objReserva;
}



public void setObjReserva(Reserva objReserva) {
	this.objReserva = objReserva;
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
 
