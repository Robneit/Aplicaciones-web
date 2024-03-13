package com.utsem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class retardo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id_retardo;
	   
	 @ManyToOne
	 private Registro registro;
	 
	 @ManyToOne
	private Quincena quincena;
	 
	 /////////////////////

	public Long getId_retardo() {
		return id_retardo;
	}

	public void setId_retardo(Long id_retardo) {
		this.id_retardo = id_retardo;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public Quincena getQuincena() {
		return quincena;
	}

	public void setQuincena(Quincena quincena) {
		this.quincena = quincena;
	}
	
}