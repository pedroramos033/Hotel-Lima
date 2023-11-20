package com.hotel.demo.service;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hotel.demo.interfaces.IReserva;
import com.hotel.demo.interfacesService.IdetalleServicioService;

import com.hotel.demo.interfacesService.IreservaService;
import com.hotel.demo.interfacesService.IservicioService;
import com.hotel.demo.modelo.Detalle_Servicio;

import com.hotel.demo.modelo.Reserva;
import com.hotel.demo.modelo.Servicio;

import jakarta.transaction.Transactional;
@Service
public class ReservaService implements IreservaService {
	@Autowired
	private IReserva data;
	
	@Autowired
	private IservicioService serviceS;
	@Autowired
	private IdetalleServicioService serviceDS;
	@Override
	public List<Reserva> listarReserva() {
		return (List<Reserva>)data.findAll();
	}

	@Override
	public Optional<Reserva> listarNro(int nro_reserva) {
		return data.findById(nro_reserva);
	}

	@Override
	public int Guardar(Reserva r) {
		// TODO Auto-generated method stub
		int res=0;
		Reserva reserva=data.save(r);
		if (!reserva.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void Borrar(int nro_reserva) {
		// TODO Auto-generated method stub
		data.deleteById(nro_reserva);
	}

	@Override
	public Reserva GuardarR(Reserva r) {
	    // Establecer un valor predeterminado si id_emp es null
	    if (r.getId_servicio() == 1) {
	        r.setId_emp(1);
	    }

	    Reserva reserva = data.save(r);
	    return reserva;
	}

	 @Transactional
	    public Reserva crearReservaConDetalle(Reserva reserva) {
	        // Obtener el servicio por ID
	        Servicio servicio = serviceS.listarId(reserva.getId_servicio()).orElse(null);

	        if (servicio != null) {
	        	
	            // Guardar la reserva
	            reserva = GuardarR(reserva);

	            // Crear y configurar el objeto Detalle_Servicio
	            Detalle_Servicio detalleServicio = new Detalle_Servicio();
	            detalleServicio.setObjReserva(reserva);
	            detalleServicio.setObjServicio(servicio);

	            // Configurar otros campos
	            detalleServicio.setId_servicio(reserva.getId_servicio());
	            detalleServicio.setHora_serv(new Time(Calendar.getInstance().getTimeInMillis()));
	            detalleServicio.setEstado_serv("No realizado"); // Estado por defecto
	            detalleServicio.setId_emp(reserva.getId_emp());
	            detalleServicio.setNro_reserva(reserva.getNro_reserva());

	            // Guardar el detalle del servicio
	            serviceDS.Guardar(detalleServicio);

	            return reserva;
	        } else {
	            throw new RuntimeException("El Servicio asociado a la reserva no existe");
	        }
	    }
	 

		    // Otros métodos

		    public double obtenerPrecioServicioPorId(int idServicio) {
		        Optional<Servicio> servicioOptional = serviceS.listarId(idServicio);
		        return servicioOptional.map(Servicio::getPrecio).orElse(0.0); // Cambiado a 0.0 para que sea un valor double
		    }

		    // Otros métodos
		
	
}
