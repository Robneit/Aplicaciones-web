package com.utsem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utsem.Service.UsuarioService;
import com.utsem.nomina.DTO.UsuarioDTO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
@Autowired
UsuarioService usuarioService;
	
	@PostMapping("mensaje") //endpoint
	public String mensaje(HttpSession sesion) {
	//if((UsuarioDTO)sesion.getAttribute("credenciales")).getRol().getNombre();
		if(sesion.getAttribute("rol")!=null&& //quienes pueden entrar a la sesion
				(sesion.getAttribute("rol").equals("Administrador")||
				sesion.getAttribute("rol").equals("Gerente")))
			return "Este mensaje solo lo puede ver el administrador o el gerente";
			return "Acceso denegado";
	}
	@PostMapping("listar")
	public List<UsuarioDTO>listar(HttpSession sesion){
		if(sesion.getAttribute("rol")!=null&& 
				sesion.getAttribute("rol").equals("Administrador")){
			return usuarioService.listar();
		}
		return null;
	}
	@PostMapping("estados")
	public String[] estados(HttpSession sesion){
		if(sesion.getAttribute("rol")!=null&& 
				sesion.getAttribute("rol").equals("Administrador")){
			return new UsuarioDTO().getEstados();
		}
		return null;
	}
	
	
	
}
