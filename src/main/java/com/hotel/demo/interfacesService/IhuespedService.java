package com.hotel.demo.interfacesService;
import java.util.List;
import java.util.Optional;


import com.hotel.demo.modelo.Huesped;

public interface IhuespedService {

	public List<Huesped>listarHuesped();
	public Optional<Huesped>listarId(int Id_huesped);
	public int Guardar(Huesped h);
	public void Borrar(int Id_huesped);
}
