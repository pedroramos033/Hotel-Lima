package com.hotel.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.demo.interfaces.IRegistroPago;
import com.hotel.demo.interfacesService.IregistroPagoService;
import com.hotel.demo.interfacesService.IreservaService;
import com.hotel.demo.interfacesService.IservicioService;
import com.hotel.demo.modelo.Registro_Pago;
import com.hotel.demo.modelo.Reserva;
@Service
public class RegistroPagoService implements IregistroPagoService{
	@Autowired
	private IRegistroPago data;
	@Autowired
    private IreservaService serviceR;
	@Autowired
    private IservicioService serviceS;
	@Override
	public List<Registro_Pago> listarRegPago() {
		return (List<Registro_Pago>)data.findAll();
	}

	@Override
	public Optional<Registro_Pago> listarId(int Id_pago) {
		// TODO Auto-generated method stub
		return data.findById(Id_pago);
	}

	@Override
	public int Guardar(Registro_Pago rp) {
		int res=0;
		Registro_Pago registro=data.save(rp);
		if (!registro.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void Borrar(int Id_pago) {
		data.deleteById(Id_pago);
		
	}

	@Override
	public Registro_Pago obtenerDetallesReservaDesdeReserva(Registro_Pago registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Registro_Pago GuardarRegistro(Registro_Pago registroPago) {
		// Obtener la reserva por número de reserva
	    Reserva reserva = serviceR.listarNro(registroPago.getNro_reserva()).orElse(null);

	    if (reserva != null) {
	        // Guardar el registro de pago
	        registroPago = GuardarDR(registroPago);

	        // Configurar el objeto Registro_Pago
	        registroPago.setObjReserva(reserva);
	        // Configurar otros campos según sea necesario
	        
	        // Guardar el registro de pago
	        Guardar(registroPago);

	        // Actualizar el estado de la reserva
	        reserva.setEstado_reserva("Pagado"); // Establecer el estado como "Pagado"
	        serviceR.Guardar(reserva) ;// Guardar la reserva actualizada

	        return registroPago;
	    } else {
	        throw new RuntimeException("La Reserva asociada al registro de pago no existe");
	    }
	}

	@Override
	public Registro_Pago GuardarDR(Registro_Pago rp) {
		Registro_Pago registrop = data.save(rp);
	    return registrop;
	}

	public IservicioService getServiceS() {
		return serviceS;
	}

	public void setServiceS(IservicioService serviceS) {
		this.serviceS = serviceS;
	}





}
