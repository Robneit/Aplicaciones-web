package com.utsem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Nomina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id_Nomina;
	 @Column
	 private Float sueldo_bruto;
	 @Column
	 private Float sueldo_neto;
	 @Column
	 private float N_falta;
	   
	 @ManyToOne
	 private Empleados empleado;
	 
	 @ManyToOne
	 private Quincena quincena;
	 
	 
	 
	 
	 ///////////////////
	 
	 

	public Long getId_Nomina() {
		return id_Nomina;
	}

	public void setId_Nomina(Long id_Nomina) {
		this.id_Nomina = id_Nomina;
	}

	public Float getSueldo_bruto() {
		return sueldo_bruto;
	}

	public void setSueldo_bruto(Float sueldo_bruto) {
		this.sueldo_bruto = sueldo_bruto;
	}

	public Float getSueldo_neto() {
		return sueldo_neto;
	}

	public void setSueldo_neto(Float sueldo_neto) {
		this.sueldo_neto = sueldo_neto;
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

	public float getN_falta() {
		return N_falta;
	}

	public void setN_falta(float n_falta) {
		N_falta = n_falta;
	}

	
	 

	 
	 
}
