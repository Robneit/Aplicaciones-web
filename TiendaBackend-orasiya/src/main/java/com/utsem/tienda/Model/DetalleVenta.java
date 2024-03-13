package com.utsem.tienda.Model;

import java.util.UUID;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	@Column
	private Float precio;
	@Column
	private Float cantidad;
	@Column
	private Float subtotal;
	
	@Column 
	private Byte estatus;
@Column(unique=true)
@GeneratedValue(strategy=GenerationType.UUID)
	private UUID uuid;
@ManyToOne
private Venta venta;

@ManyToOne
private Producto producto;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

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

public Venta getVenta() {
	return venta;
}

public void setVenta(Venta venta) {
	this.venta = venta;
}

public Producto getProducto() {
	return producto;
}

public void setProducto(Producto producto) {
	this.producto = producto;
}


}
