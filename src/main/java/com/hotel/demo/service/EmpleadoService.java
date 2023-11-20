package com.hotel.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.demo.interfaces.IEmpleado;
import com.hotel.demo.interfacesService.IempleadoService;
import com.hotel.demo.modelo.Empleado;

@Service
public class EmpleadoService implements IempleadoService {
	@Autowired
	private IEmpleado data;
	@Override
	public List<Empleado> listarEmpleado() {
		return (List<Empleado>)data.findAll();
	}

	@Override
	public Optional<Empleado> listarId(Integer Id_emp) {
		// TODO Auto-generated method stub
		return data.findById(Id_emp);
	}

	@Override
	public int Guardar(Empleado e) {
		// TODO Auto-generated method stub
		int res=0;
		Empleado empleado=data.save(e);
		if (!empleado.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void Borrar(Integer Id_emp) {
		// TODO Auto-generated method stub
		data.deleteById(Id_emp);
	}

}
