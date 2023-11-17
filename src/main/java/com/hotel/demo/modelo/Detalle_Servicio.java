
  package com.hotel.demo.modelo; import java.sql.Time;
  
  import jakarta.persistence.Entity; import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
  import jakarta.persistence.JoinColumn; import jakarta.persistence.ManyToOne;
  import jakarta.persistence.Table;
  
  @Entity
  
  @Table(name = "detalle_servicio") public class Detalle_Servicio {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_detaserv;
  private Time hora_serv; 
  private String estado_serv; 
  private int nro_reserva;
  private int id_emp;
  
  public Detalle_Servicio() { super(); }
  
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
  
  @ManyToOne
  
  @JoinColumn(name="nro_reserva", insertable=false,updatable=false) private
  Reserva objReserva;
  
  
  @ManyToOne
  
  @JoinColumn(name="id_emp", insertable=false,updatable=false) private Empleado
  objEmpleado;
  
  }
 
