package com.utsem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utsem.Service.UsuarioService;
import com.utsem.nomina.DTO.LoginDTO;
import com.utsem.nomina.DTO.RespuestaDTO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("auth")
@RestController
public class AuthController {
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
		@PostMapping("login") //endpoint
		public RespuestaDTO login(HttpSession sesion,
				@RequestBody LoginDTO datos) {
			return usuarioService.acceso(sesion, datos);
		}
		@PostMapping("estatus")
		public RespuestaDTO estado(HttpSession sesion) {
			return sesion.getAttribute("estatus")!=null? 
					(RespuestaDTO)sesion.getAttribute("estatus"):
			new RespuestaDTO();
		}
		@PostMapping("logout") //endpoint
		public void logout(HttpSession sesion) {
		sesion.invalidate();
		//sesion.removeAttribute("credenciales"); el id de la sesion se mantiene cada que inicias sesion
		
		}
	}