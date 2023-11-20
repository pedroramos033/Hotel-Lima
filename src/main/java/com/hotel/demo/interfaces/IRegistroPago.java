package com.hotel.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.demo.modelo.Registro_Pago;
@Repository
public interface IRegistroPago extends CrudRepository<Registro_Pago, Integer> {

}
