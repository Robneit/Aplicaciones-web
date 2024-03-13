package com.utsem.nomina.DTO;

public class RespuestaDTO {
	 boolean AccesoCorrecto=false;
	 String ruta="";
	 String mensaje;
	 ////
	public boolean isAccesoCorrecto() {
		return AccesoCorrecto;
	}
	public void setAccesoCorrecto(boolean accesoCorrecto) {
		AccesoCorrecto = accesoCorrecto;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	 
	}
