package com.utsem.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Empleados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long n_empleado;
	@Column
	private String nombre;
	@Column
	private String paterno;
	@Column
	private String materno;
	@Column
	private LocalDateTime fecha_nacimiento;
	@Column
	private LocalDateTime fecha_ingreso;
	@Column
	private Byte estatus;
	@Column
	private Byte salario;
	@Column
	private Byte ISR;
	
	/////////////////////////
	
	public Long getN_empleado() {
		return n_empleado;
	}
	public void setN_empleado(Long n_empleado) {
		this.n_empleado = n_empleado;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Byte getSalario() {
		return salario;
	}
	public void setSalario(Byte salario) {
		this.salario = salario;
	}
	public Byte getISR() {
		return ISR;
	}
	public void setISR(Byte iSR) {
		ISR = iSR;
	}
}
