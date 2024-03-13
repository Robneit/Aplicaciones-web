package com.utsem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quincena {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id_quincena;
	 @Column
	 private Long n_quincea;
	 @Column
	 private String mes;
	 @Column
	 private String Anio;
	   
	 
	 //////////////////////////////////////////////

	public Long getId() {
		return id_quincena;
	}

	public void setId(Long id) {
		this.id_quincena = id;
	}

	public Long getN_quincea() {
		return n_quincea;
	}

	public void setN_quincea(Long n_quincea) {
		this.n_quincea = n_quincea;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return Anio;
	}

	public void setAnio(String anio) {
		Anio = anio;
	} 
}
