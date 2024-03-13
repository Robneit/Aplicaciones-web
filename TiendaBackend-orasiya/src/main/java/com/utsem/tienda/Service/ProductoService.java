package com.utsem.tienda.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsem.tienda.DTO.ProductoDTO;
import com.utsem.tienda.Model.Producto;
import com.utsem.tienda.repository.ProductoRepository;
@Service
public class ProductoService {
	@Autowired
    private ProductoRepository productoRepository; 

	    public List<ProductoDTO> obtenerProductos() {
	        List<Producto> productos = productoRepository.findAll();
	        List<ProductoDTO> productosDTO = new ArrayList<>();

	        for (Producto producto : productos) {
	            ProductoDTO productoDTO = new ProductoDTO();
	            productoDTO.setDescripcion(producto.getDescripcion());
	            productoDTO.setPrecio(producto.getPrecio());
	            productoDTO.setCodigo(producto.getCodigo());
	            productosDTO.add(productoDTO);
	        }
	        return productosDTO;
	    }
	}
