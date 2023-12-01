package com.hotel.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.demo.modelo.Usuarios;
@Repository
public interface IUsuarios extends CrudRepository<Usuarios, Long>{

	
		public Usuarios findByEmail(String email);
}

