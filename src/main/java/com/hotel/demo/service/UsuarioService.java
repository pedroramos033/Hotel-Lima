package com.hotel.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.callback.PasswordCallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.demo.dto.UsuarioRegistroDTO;
import com.hotel.demo.interfacesService.IUsuarioService;
import com.hotel.demo.modelo.Rol;
import com.hotel.demo.modelo.Usuarios;
import com.hotel.demo.interfaces.IUsuarios;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarios data;
	

	


	@Override
	public Usuarios save(UsuarioRegistroDTO registroDTO) {
		Usuarios a = new Usuarios(registroDTO.getNombre(),
				registroDTO.getApellido(),
				registroDTO.getEmail(),
				registroDTO.getPassword(),
				Arrays.asList(new Rol("admin")));
		
		return data.save(a);
	}


	@Override
	public List<Usuarios> listarUsuarios() {
		return (List<Usuarios>)data.findAll();
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuario = data.findByEmail(username);
		if(usuario == null)
		{ throw new UsernameNotFoundException("Usuario o contraseña inválidos");}
		
		return new User(usuario.getEmail(), usuario.getPassword(),mappingRoles(usuario.getRoles()));
		}
	
	private Collection<? extends GrantedAuthority> mappingRoles(Collection<Rol> roles){
	return roles.stream().map(role -> new SimpleGrantedAuthority(role.getDescripcion())).collect(Collectors.toList());
	}
	
}
