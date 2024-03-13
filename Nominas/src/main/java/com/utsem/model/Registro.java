package com.utsem.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Registro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_registro;
	@Column
	private Long tipo;
	@Column
	private LocalDateTime fecha_hora;
	
	@ManyToOne
	private Empleados empleado;
	@ManyToOne
	private Quincena quincena;
	
	
	//////////////////
	
	
	public Quincena getQuincena() {
		return quincena;
	}
	public void setQuincena(Quincena quincena) {
		this.quincena = quincena;
	}
	public Empleados getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	public Long getId_registro() {
		return id_registro;
	}
	public void setId_registro(Long id_registro) {
		this.id_registro = id_registro;
	}
	public Long getTipo() {
		return tipo;
	}
	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
}
