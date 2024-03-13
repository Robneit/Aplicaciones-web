package com.utsem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utsem.DTO.FiltrosUsuarioDTO;
import com.utsem.DTO.UsuarioDTO;
import com.utsem.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	
	@PostMapping ("mensaje")
	public String mensaje(HttpSession sesion) {
		if(sesion.getAttribute("rol")!=null&&
				(sesion.getAttribute("rol").equals("Admin")||
				sesion.getAttribute("rol").equals("gerente")))
			return "este mensaje solo lo puede ver el administrador";
		return "acceso denegado";
	}
	@PostMapping ("listar")	
	public List<UsuarioDTO> listar (HttpSession sesion){
		if(sesion.getAttribute("rol")!=null&&
				sesion.getAttribute("rol").equals("Admin")){
			
		return usuarioService.listar();
		}
		return null;
	}
	@PostMapping ("estados")	
	public String[] estados (HttpSession sesion){
		if(sesion.getAttribute("rol")!=null&&
				sesion.getAttribute("rol").equals("Admin")){
		return new UsuarioDTO().getEstados();
		}
		return null;
	}
	
	@PostMapping ("filtrar")	
	public List<UsuarioDTO> filtrar (HttpSession sesion,
	@RequestBody FiltrosUsuarioDTO filtros){
		if(sesion.getAttribute("rol")!=null&&
				sesion.getAttribute("rol").equals("Admin")){
			
		return usuarioService.listar();
		}
		return null;
	}
}

