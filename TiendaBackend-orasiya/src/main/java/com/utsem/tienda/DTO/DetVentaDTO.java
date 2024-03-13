package com.utsem.tienda.DTO;

import java.util.UUID;

public class DetVentaDTO {
	
	private Float precio;
	private Float cantidad;
	private Float subtotal;
	private Byte estatus=1;
	private UUID uuid=UUID.randomUUID();
	private ProductoDTO productoDTO;
	
	
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
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
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}
	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}
	
	
}
