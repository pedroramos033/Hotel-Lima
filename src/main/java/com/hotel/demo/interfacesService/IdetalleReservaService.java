package com.hotel.demo.interfacesService;
import java.util.List;
import java.util.Optional;

import com.hotel.demo.modelo.Detalle_Reserva;



public interface IdetalleReservaService {
	public List<Detalle_Reserva>listarDetReserva();
	public Optional<Detalle_Reserva>listarId(int Id_detreserva);
	public int Guardar(Detalle_Reserva dr);
	public void Borrar(int Id_detreserva);
	public Detalle_Reserva GuardarDR(Detalle_Reserva dr);
	public Detalle_Reserva crearReservaConDetalle(Detalle_Reserva detreserva);
}
