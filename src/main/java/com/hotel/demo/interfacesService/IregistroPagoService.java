package com.hotel.demo.interfacesService;
import java.util.List;
import java.util.Optional;

import com.hotel.demo.modelo.Detalle_Reserva;
import com.hotel.demo.modelo.Registro_Pago;
import com.hotel.demo.modelo.Reserva;
public interface IregistroPagoService {
	public List<Registro_Pago>listarRegPago();
	public Optional<Registro_Pago>listarId(int Id_pago);
	public int Guardar(Registro_Pago rp);
	public void Borrar(int Id_pago);
	public Registro_Pago obtenerDetallesReservaDesdeReserva(Registro_Pago registro);
	public Registro_Pago GuardarDR(Registro_Pago rp);
	public Registro_Pago GuardarRegistro(Registro_Pago registroPago);
}
