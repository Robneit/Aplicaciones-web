package com.utsem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Faltas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id_Falta;
	   
	 @ManyToOne
	 private Empleados empleado;
	 
	 @ManyToOne
	 private Quincena quincena;
	 
	 
	 /////////////////////

	public Long getId_Falta() {
		return id_Falta;
	}

	public void setId_Falta(Long id_Falta) {
		this.id_Falta = id_Falta;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public Quincena getQuincena() {
		return quincena;
	}

	public void setQuincena(Quincena quincena) {
		this.quincena = quincena;
	}
	 
	 
	 /////////////////////////
	 
}
