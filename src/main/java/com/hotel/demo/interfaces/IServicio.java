package com.hotel.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.demo.modelo.Servicio;
@Repository
public interface IServicio extends CrudRepository<Servicio, Integer>{

}
