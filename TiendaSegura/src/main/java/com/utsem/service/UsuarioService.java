package com.utsem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsem.DTO.FiltrosUsuarioDTO;
import com.utsem.DTO.LoginDTO;
import com.utsem.DTO.RespuestaDTO;
import com.utsem.DTO.UsuarioDTO;
import com.utsem.Repository.UsuarioRepository;
import com.utsem.model.Usuario;
import com.utsem.specificacion.UsuarioSpecificacion;

import jakarta.servlet.http.HttpSession;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	ModelMapper mapper;
	
	public RespuestaDTO acceso (HttpSession sesion, LoginDTO datos) {
		
		RespuestaDTO res= new RespuestaDTO();
		Optional<Usuario>usuario=usuarioRepository.
				findByUsernameAndPassword(
				datos.getUsername(), 
				datos.getPassword());
		if (usuario.isEmpty()) {
			res.setMensaje("acceso denegado");
		}
		else {
			UsuarioDTO credenciales=mapper.map(
					usuario.get(), UsuarioDTO.class);
			if(credenciales.getRol().getNombre().equals("Admin"))
				res.setRuta("admin.html");
			if(credenciales.getRol().getNombre().equals("usuario"))
				res.setRuta("usuario.html");
			sesion.setAttribute("credenciales", credenciales);
			sesion.setAttribute("rol", credenciales.getRol().getNombre());
			sesion.setAttribute("estatus", res);
			res.setMensaje("Acceso correcto");
			res.setAccesoCorrecto(true);
	}
		return res;
	}
	
	public List<UsuarioDTO> listar() {
		return usuarioRepository.findByNombreContainsOrPaternoContainsOrMaternoContains(null, null, null).stream()
		.map(user->mapper.map(user, UsuarioDTO.class))
		.collect(Collectors.toList());
	}
	public List<UsuarioDTO> filtrar(FiltrosUsuarioDTO filtros) {
		return usuarioRepository.findAll(new UsuarioSpecificacion(filtros))
				.stream()
		.map(user->mapper.map(user, UsuarioDTO.class))
		.collect(Collectors.toList());
	}
}
