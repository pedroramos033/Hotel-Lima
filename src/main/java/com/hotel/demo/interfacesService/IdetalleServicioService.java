package com.hotel.demo.interfacesService;
import java.util.List;
import java.util.Optional;

import com.hotel.demo.modelo.Detalle_Servicio;


public interface IdetalleServicioService {
	public List<Detalle_Servicio>listarDetServicio();
	public Optional<Detalle_Servicio>listarId(int Id_detservicio);
	public int Guardar(Detalle_Servicio ds);
	public void Borrar(int Id_detservicio);
}
