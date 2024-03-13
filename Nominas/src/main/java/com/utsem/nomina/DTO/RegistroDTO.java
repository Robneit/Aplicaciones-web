package com.utsem.nomina.DTO;

import java.time.LocalDateTime;



public class RegistroDTO {
	
	private Long tipo;
	
	private LocalDateTime fecha_hora;
	
	private EmpleadosDTO empleadosDTO;
	
	private QuincenaDTO quincenaDTO;
	
	//////////////////

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

	public EmpleadosDTO getEmpleadosDTO() {
		return empleadosDTO;
	}

	public void setEmpleadosDTO(EmpleadosDTO empleadosDTO) {
		this.empleadosDTO = empleadosDTO;
	}

	public QuincenaDTO getQuincenaDTO() {
		return quincenaDTO;
	}

	public void setQuincenaDTO(QuincenaDTO quincenaDTO) {
		this.quincenaDTO = quincenaDTO;
	}
	
	
	
}
