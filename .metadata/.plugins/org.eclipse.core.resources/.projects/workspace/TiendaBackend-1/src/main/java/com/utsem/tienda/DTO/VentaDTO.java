package com.utsem.tienda.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VentaDTO {
	private Float total=0f;
	private LocalDateTime fechaCreacion;
	private Byte estatus=1;
	private UUID uuid=UUID.randomUUID();
	private List<DetVentaDTO>detalles =new ArrayList<>();
		
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
	public List<DetVentaDTO> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetVentaDTO> detalles) {
		this.detalles = detalles;
	}
}
