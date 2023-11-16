package com.hotel.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hotel.demo.modelo.Habitacion;
@Repository
public interface IHabitacion extends CrudRepository<Habitacion, Integer> {

}
