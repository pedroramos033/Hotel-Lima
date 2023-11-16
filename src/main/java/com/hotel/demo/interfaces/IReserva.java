package com.hotel.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.demo.modelo.Reserva;
@Repository
public interface IReserva extends CrudRepository<Reserva, Integer>{

}
