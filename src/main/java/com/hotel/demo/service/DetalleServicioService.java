package com.hotel.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.demo.interfaces.IDetalleServicio;
import com.hotel.demo.interfacesService.IdetalleServicioService;
import com.hotel.demo.modelo.Detalle_Servicio;

@Service
public class DetalleServicioService implements IdetalleServicioService {
	@Autowired
	private IDetalleServicio data;
	@Override
	public List<Detalle_Servicio> listarDetServicio() {
		return (List<Detalle_Servicio>)data.findAll();
	}

	@Override
	public Optional<Detalle_Servicio> listarId(int Id_detservicio) {
		return data.findById(Id_detservicio);
	}

	@Override
	public int Guardar(Detalle_Servicio ds) {
		int res=0;
		Detalle_Servicio detalleservicio=data.save(ds);
		if (!detalleservicio.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void Borrar(int Id_detservicio) {
		data.deleteById(Id_detservicio);
		
	}

}
