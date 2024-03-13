package com.utsem.DTO;

public class RespuestaDTO {
	boolean accesoCorrecto=false;
	String ruta="";
	
	String mensaje="";
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	////////////////
	public boolean isAccesoCorrecto() {
		return accesoCorrecto;
	}
	public void setAccesoCorrecto(boolean accesoCorrecto) {
		this.accesoCorrecto = accesoCorrecto;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	
}
