package com.utsem.tienda.Model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	@Column 
	private Float total;
	@CreationTimestamp
@Column 
	private LocalDateTime fechaCreacion;
	@Column 
	private Byte estatus;
@Column(unique=true)
@GeneratedValue(strategy=GenerationType.UUID)
	private UUID uuid;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Float getTotal() {
	return total;
}
public void setTotal(Float total) {
	this.total = total;
}
public LocalDateTime getFechaCreacion() {
	return fechaCreacion;
}
public void setFechaCreacion(LocalDateTime fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
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
