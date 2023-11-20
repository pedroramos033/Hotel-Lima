package com.hotel.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.demo.modelo.Detalle_Reserva;

@Repository
public interface IDetalleReserva extends CrudRepository<Detalle_Reserva, Integer> {

}
