package com.hotel.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.demo.interfaces.IDetalleReserva;
import com.hotel.demo.interfacesService.IdetalleReservaService;
import com.hotel.demo.interfacesService.IhabitacionService;

import com.hotel.demo.modelo.Detalle_Reserva;
import com.hotel.demo.modelo.Habitacion;


import jakarta.transaction.Transactional;

@Service
public class DetalleReservaService implements IdetalleReservaService {
	@Autowired
	private IDetalleReserva data;
	@Autowired
	private IhabitacionService ServiceH;
	
	@Override
	public List<Detalle_Reserva> listarDetReserva() {
		return (List<Detalle_Reserva>)data.findAll();
	}

	@Override
	public Optional<Detalle_Reserva> listarId(int Id_detreserva) {
		return data.findById(Id_detreserva);
	}

	@Override
	public int Guardar(Detalle_Reserva dr) {
		int res=0;
		Detalle_Reserva detallereserva=data.save(dr);
		if (!detallereserva.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void Borrar(int Id_detreserva) {
		data.deleteById(Id_detreserva);
	}
	@Override
	public Detalle_Reserva GuardarDR(Detalle_Reserva dr) {
		    // Establecer un valor predeterminado si id_emp es null
		    
		Detalle_Reserva detreserva = data.save(dr);
		    return detreserva;
		}
	
	@Transactional
	public Detalle_Reserva crearReservaConDetalle(Detalle_Reserva detreserva) {
	    // Obtener la habitación por ID
	    Habitacion habitacion = ServiceH.listarNro(detreserva.getNro_habi()).orElse(null);

	    if (habitacion != null) {
	        // Guardar la reserva
	    	detreserva = GuardarDR(detreserva);

	        // Configurar el objeto Detalle_Reserva
	        
	        
	        detreserva.setObjHabitacion(habitacion);
	        // Configurar otros campos según sea necesario

	        // Guardar el detalle de la reserva
	        Guardar(detreserva);

	        // Actualizar el estado de la habitación
	        habitacion.reservar(); // Utiliza el método que actualiza el estado
	        ServiceH.Guardar(habitacion); // Guarda la habitación actualizada

	        return detreserva;
	    } else {
	        throw new RuntimeException("La Habitación asociada a la reserva no existe");
	    }
	}

	
}
