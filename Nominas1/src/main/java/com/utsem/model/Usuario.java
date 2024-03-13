package com.utsem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id_Usuario;
	
	 @Column
	 private String Rol;
	 
	 
	 //////////////////////
	 

	public Long getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Long id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getRol() {
		return Rol;
	}

	public void setRol(String rol) {
		Rol = rol;
	}
	 

	 
}
