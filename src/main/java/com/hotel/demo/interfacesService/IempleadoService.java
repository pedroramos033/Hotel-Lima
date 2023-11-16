package com.hotel.demo.interfacesService;
import java.util.List;
import java.util.Optional;

import com.hotel.demo.modelo.Empleado;

public interface IempleadoService {
	public List<Empleado>listarEmpleado();
	public Optional<Empleado>listarId(int Id_emp);
	public int Guardar(Empleado e);
	public void Borrar(int Id_emp);
}
