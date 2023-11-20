package com.hotel.demo.service;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.demo.interfaces.IHabitacion;

import com.hotel.demo.interfacesService.IhabitacionService;

import com.hotel.demo.modelo.Habitacion;
import com.hotel.demo.modelo.Reserva;

import jakarta.transaction.Transactional;

@Service
public class HabitacionService implements IhabitacionService {

	@Autowired
	private IHabitacion data;
	
	@Override
	public List<Habitacion> listar() {
		return (List<Habitacion>)data.findAll();
	}

	@Override
	public Optional<Habitacion> listarNro(int Nro_habi) {
		// TODO Auto-generated method stub
		return data.findById(Nro_habi);
	}

	@Override
	@Transactional
	public int Guardar(Habitacion h) {
		int res=0;
		Habitacion habitacion=data.save(h);
		if (!habitacion.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void Borrar(int Nro_habi) {
		data.deleteById(Nro_habi);
		
	}

	@Override
    @Transactional
    public void GuardarYFlushear(Habitacion habitacion) {
        Reserva reserva = habitacion.getObjReserva(); // Asumiendo que hay un método getReserva en Habitacion
		 
        if (reserva != null) {	
            habitacion.setEstado("No Disponible");
            data.saveAndFlush(habitacion);
        }
    }

	@Override
	public void flush() {
        data.flush();
    }
	
	

	

}
