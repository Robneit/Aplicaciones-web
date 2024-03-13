package com.utsem.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utsem.tienda.Model.Producto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ProductoRepository extends JpaRepository<Producto, Long>{
	Optional<Producto> findByCodigo(String codigo);
	Optional<Producto> findByUuid(UUID uuid);
	
	 List<Producto> findByDescripcionContainingIgnoreCase(String descripcion);
}
