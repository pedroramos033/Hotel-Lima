package com.hotel.demo.interfacesService;
import java.util.List;
import java.util.Optional;


import com.hotel.demo.modelo.Reserva;
public interface IreservaService {
	public List<Reserva>listarReserva();
	public Optional<Reserva>listarNro(int nro_reserva);
	public int Guardar(Reserva r);
	public void Borrar(int nro_reserva);
	public Reserva GuardarR(Reserva r);
	public Reserva crearReservaConDetalle(Reserva reserva);
	public double obtenerPrecioServicioPorId(int idServicio);
}
