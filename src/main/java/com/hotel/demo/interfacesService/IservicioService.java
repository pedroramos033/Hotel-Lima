package com.hotel.demo.interfacesService;

import java.util.List;
import java.util.Optional;

import com.hotel.demo.modelo.Servicio;

public interface IservicioService {
	public List<Servicio>listarServicio();
	public Optional<Servicio>listarId(int Id_servicio);
	public int Guardar(Servicio s);
	public void Borrar(int Id_servicio);
}
