package com.utsem.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utsem.tienda.Model.DetalleVenta;

public interface DetVentaRepository extends JpaRepository<DetalleVenta, Long> {

}
