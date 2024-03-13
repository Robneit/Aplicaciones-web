package com.utsem.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 //todas las pautas que se tienen que seguir se deben hacer en service

import com.utsem.Repository.UsuarioRepository;
import com.utsem.model.Usuario;
import com.utsem.nomina.DTO.LoginDTO;
import com.utsem.nomina.DTO.RespuestaDTO;
import com.utsem.nomina.DTO.UsuarioDTO;

import jakarta.servlet.http.HttpSession;
@Service
public class UsuarioService {

	@Autowired 
	UsuarioRepository usuarioRepository;
	@Autowired
	ModelMapper mapper;

	
	public RespuestaDTO acceso(HttpSession sesion, LoginDTO datos) {
		RespuestaDTO res= new RespuestaDTO();
		Optional<Usuario> usuario=usuarioRepository.findByUsernameAndPassword( datos.getUsername(),datos.getPassword());
		if(usuario.isEmpty()) {         
			res.setMensaje("Acceso denegado");
		}
		else {
			UsuarioDTO credenciales=mapper.map(usuario.get(), UsuarioDTO.class); //si existen crea unas credenciales con los usuarios
			if(credenciales.getRol().getNombre().equals("Admin"))
				res.setRuta("formnomi.html");
			if(credenciales.getRol().getNombre().equals("User"))
				res.setRuta("inicio.html");
			sesion.setAttribute("credenciales", credenciales); //informacion del usuario
			sesion.setAttribute("estatus", res);
			sesion.setAttribute("rol", credenciales.getRol().getNombre());
			res.setMensaje("Acceso Correcto");
			res.setAccesoCorrecto(true);
		}
	return res;
	}
	public List<UsuarioDTO> listar() { 
		 return usuarioRepository.findAll().stream()
		.map(user->mapper.map(user, UsuarioDTO.class)) 
	    .collect(Collectors.toList()); 
	}

}
