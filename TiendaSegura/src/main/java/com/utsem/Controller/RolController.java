package com.utsem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utsem.DTO.RolDTO;
import com.utsem.service.RolService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("roles")
public class RolController {
	@Autowired
	RolService rolService;
	
	@PostMapping ("listar")	
	public List<RolDTO> listar (HttpSession sesion){
		if(sesion.getAttribute("rol")!=null&&
				sesion.getAttribute("rol").equals("Admin")){
			
		return rolService.listar();
		}
		return null;
	}
}
