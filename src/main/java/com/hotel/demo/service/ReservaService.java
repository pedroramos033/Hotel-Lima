package com.hotel.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hotel.demo.interfaces.IReserva;
import com.hotel.demo.interfacesService.IreservaService;
import com.hotel.demo.modelo.Reserva;
@Service
public class ReservaService implements IreservaService {
	@Autowired
	private IReserva data;
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

}
