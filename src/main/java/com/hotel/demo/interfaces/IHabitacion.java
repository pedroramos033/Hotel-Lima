package com.hotel.demo.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.demo.modelo.Habitacion;
@Repository
public interface IHabitacion extends JpaRepository<Habitacion, Integer> {

}
