package com.utsem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utsem.DTO.LoginDTO;
import com.utsem.DTO.RespuestaDTO;
import com.utsem.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("auth")
public class AuthController {
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("login")
	public RespuestaDTO login(HttpSession sesion, @RequestBody LoginDTO datos) {
		System.out.println(sesion.getId());
		return usuarioService.acceso(sesion, datos);
	}
	@PostMapping ("estatus")
	public RespuestaDTO estado(HttpSession sesion) {
		return sesion.getAttribute("estatus")!=null?
				(RespuestaDTO)sesion.getAttribute("estatus"):
					new RespuestaDTO();
		}
	@PostMapping ("logout")
	public void logout(HttpSession sesion) {
		System.out.println(sesion.getId());
		sesion.invalidate();
		//sesion.removeAttribute("credenciales");
		
	}
}
