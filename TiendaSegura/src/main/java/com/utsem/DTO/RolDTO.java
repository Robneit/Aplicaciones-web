package com.utsem.DTO;

import java.util.UUID;

public class RolDTO {

	private String username;

	private String nombre;

	private String paterno;

	private String materno;

	private Byte estatus;

	private UUID uuid;

	///////////////////////////

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Byte getEstatus() {
		return estatus;
	}

	public void setEstatus(Byte estatus) {
		this.estatus = estatus;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}
