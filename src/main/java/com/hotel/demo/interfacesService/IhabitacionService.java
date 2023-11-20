package com.hotel.demo.interfacesService;
import java.util.List;
import java.util.Optional;
import com.hotel.demo.modelo.Habitacion;

import jakarta.transaction.Transactional;

public interface IhabitacionService {
	public List<Habitacion>listar();
	public Optional<Habitacion>listarNro(int Nro_habi);
	public int Guardar(Habitacion h);
	public void Borrar(int Nro_habi);
	public void GuardarYFlushear(Habitacion habitacion);
	@Transactional
    void flush();
}
