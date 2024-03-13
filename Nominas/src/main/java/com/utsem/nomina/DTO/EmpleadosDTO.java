package com.utsem.nomina.DTO;

import java.time.LocalDateTime;


public class EmpleadosDTO {
	
	private Long n_empleado;

	private String nombre;

	private String paterno;
	
	private String materno;

	private LocalDateTime fecha_nacimiento;

	private LocalDateTime fecha_ingreso;

	private Byte estatus;
	

	//////////////////////

	public Long getN_empleado() {
		return n_empleado;
	}

	public void setN_empleado(Long n_empleado) {
		this.n_empleado = n_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public LocalDateTime getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public LocalDateTime getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(LocalDateTime fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Byte getEstatus() {
		return estatus;
	}

	public void setEstatus(Byte estatus) {
		this.estatus = estatus;
	}	
}
