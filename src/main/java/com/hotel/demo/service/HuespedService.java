package com.hotel.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hotel.demo.interfaces.IHuesped;
import com.hotel.demo.interfacesService.IhuespedService;
import com.hotel.demo.modelo.Huesped;
@Service
public class HuespedService implements IhuespedService{
	@Autowired
	private IHuesped data;
	@Override
	public List<Huesped> listarHuesped() {
		return (List<Huesped>)data.findAll();
	}

	@Override
	public Optional<Huesped> listarId(int Id_huesped) {
		// TODO Auto-generated method stub
		return data.findById(Id_huesped);
	}

	@Override
	public int Guardar(Huesped h) {
		int res=0;
		Huesped huesped=data.save(h);
		if (!huesped.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void Borrar(int Id_huesped) {
		data.deleteById(Id_huesped);
		
	}

}
