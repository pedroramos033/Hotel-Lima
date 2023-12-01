package com.hotel.demo.interfacesService;

 import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hotel.demo.dto.UsuarioRegistroDTO; 
import com.hotel.demo.modelo.Usuarios;

public interface IUsuarioService extends UserDetailsService{
public Usuarios save(UsuarioRegistroDTO registroDTO);
public List<Usuarios> listarUsuarios();
  }


