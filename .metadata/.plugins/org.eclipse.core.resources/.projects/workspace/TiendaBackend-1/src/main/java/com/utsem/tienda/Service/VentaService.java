package com.utsem.tienda.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.utsem.tienda.DTO.DetVentaDTO;
import com.utsem.tienda.DTO.ProductoDTO;
import com.utsem.tienda.DTO.VentaDTO;
import com.utsem.tienda.Model.DetalleVenta;
import com.utsem.tienda.Model.Producto;
import com.utsem.tienda.Model.Venta;
import com.utsem.tienda.repository.DetVentaRepository;
import com.utsem.tienda.repository.ProductoRepository;
import com.utsem.tienda.repository.VentaRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class VentaService {
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	VentaRepository ventaRepository;
	@Autowired
	DetVentaRepository detVentaRepository;

	public String buscaProductoPorCodigo(HttpSession sesion, @RequestBody ProductoDTO productoDTO) {
		// busco el producto por codigo
		Optional<Producto> pro = productoRepository.findByCodigo(productoDTO.getCodigo());
		if (pro.isPresent()) {
			// si la venta del cliente no existe, le crea una nueva
			if (sesion.getAttribute("miVenta") == null) {
				sesion.setAttribute("miVenta", new VentaDTO());
			}
			VentaDTO ventaDTO = (VentaDTO) sesion.getAttribute("miVenta");
			Boolean existe = false;
			for (int i = 0; i < ventaDTO.getDetalles().size(); i++) {

				DetVentaDTO det = ventaDTO.getDetalles().get(i);
				if (det.getProductoDTO().getUuid().compareTo(pro.get().getUuid()) == 0) {
					det.setCantidad(det.getCantidad() + 1);
					det.setSubtotal(det.getCantidad() * det.getPrecio());
					existe = true;
					break;
				}
			}
			if (!existe) {
				DetVentaDTO detVentaDTO = new DetVentaDTO();
				detVentaDTO.setCantidad((float) 1);
				detVentaDTO.setPrecio(pro.get().getPrecio());
				detVentaDTO.setSubtotal(detVentaDTO.getCantidad() * detVentaDTO.getPrecio());
				detVentaDTO.setProductoDTO(modelMapper.map(pro.get(), ProductoDTO.class));
				ventaDTO.getDetalles().add(detVentaDTO);
			}
			float suma = 0f;
			for (int i = 0; i < ventaDTO.getDetalles().size(); i++)
				suma += ventaDTO.getDetalles().get(i).getSubtotal();
			ventaDTO.setTotal(suma);
			return "producto encontrado y agregado a la venta";
		} else {
			return "producto no encontrado";
		}
	}

	public VentaDTO consultaVenta(HttpSession sesion) {
		// si la venta del cliente no existe, le crea una nueva
		if (sesion.getAttribute("miVenta") == null) {
			sesion.setAttribute("miVenta", new VentaDTO());
		}
		return (VentaDTO) sesion.getAttribute("miVenta");
	}

	public String limpiaVenta(HttpSession sesion) {
		sesion.setAttribute("miVenta", new VentaDTO());
		return "ya no existe venta en el carrito";
	}

	public String eliminarDetalle(HttpSession sesion, int pos) {
		VentaDTO ventaDTO = (VentaDTO) sesion.getAttribute("miVenta");
		ventaDTO.getDetalles().remove(pos);

		return "detalle eliminado";
	}

	public String guardaVenta(HttpSession sesion) {
		VentaDTO ventaDTO = (VentaDTO) sesion.getAttribute("miVenta");
		Venta miVenta = modelMapper.map(ventaDTO, Venta.class);
		ventaRepository.save(miVenta);
		for (int i = 0; i < ventaDTO.getDetalles().size(); i++) {
			DetVentaDTO det = ventaDTO.getDetalles().get(i);
			DetalleVenta miDetalle=modelMapper.map(det,DetalleVenta.class);
			miDetalle.setProducto(productoRepository.findByUuid(det.getProductoDTO().getUuid()).get());
			miDetalle.setVenta(miVenta);
			detVentaRepository.save(miDetalle);
		}
		return "Venta Guardada";
	}
	public String eliminarUno(HttpSession sesion, int pos) {
	    VentaDTO ventaDTO = (VentaDTO) sesion.getAttribute("miVenta");
	    if (ventaDTO.getDetalles().size() > pos) {
	        DetVentaDTO detalle = ventaDTO.getDetalles().get(pos);
	        if (detalle.getCantidad() > 1) {
	            detalle.setCantidad(detalle.getCantidad() - 1);
	            detalle.setSubtotal(detalle.getPrecio() * detalle.getCantidad());
	            actualizarTotalVenta(ventaDTO);
	        } else {
	            ventaDTO.getDetalles().remove(pos);
	            actualizarTotalVenta(ventaDTO);
	        }
	        return "Se eliminó 1 del producto.";
	    }
	    return "No se pudo eliminar uno del producto.";
	}

	public String Uno(HttpSession sesion, int pos) {
	    VentaDTO ventaDTO = (VentaDTO) sesion.getAttribute("miVenta");
	    if (ventaDTO.getDetalles().size() > pos) {
	        DetVentaDTO detalle = ventaDTO.getDetalles().get(pos);
	        detalle.setCantidad(detalle.getCantidad() + 1);
	        detalle.setSubtotal(detalle.getPrecio() * detalle.getCantidad());
	        actualizarTotalVenta(ventaDTO);
	        return "Se agregó 1 al producto.";
	    }
	    return "No se pudo agregar uno al producto.";
	}
	public String Cinco(HttpSession sesion, int pos) {
	    VentaDTO ventaDTO = (VentaDTO) sesion.getAttribute("miVenta");
	    if (ventaDTO.getDetalles().size() > pos) {
	        DetVentaDTO detalle = ventaDTO.getDetalles().get(pos);
	        detalle.setCantidad(detalle.getCantidad() + 5);
	        detalle.setSubtotal(detalle.getPrecio() * detalle.getCantidad());
	        actualizarTotalVenta(ventaDTO);
	        return "Se agregaron 5 al producto.";
	    }
	    return "No se pudieron agregar cinco al producto.";
	}

	public String Diez(HttpSession sesion, int pos) {
	    VentaDTO ventaDTO = (VentaDTO) sesion.getAttribute("miVenta");
	    if (ventaDTO.getDetalles().size() > pos) {
	        DetVentaDTO detalle = ventaDTO.getDetalles().get(pos);
	        detalle.setCantidad(detalle.getCantidad() + 10);
	        detalle.setSubtotal(detalle.getPrecio() * detalle.getCantidad());
	        actualizarTotalVenta(ventaDTO);
	        return "Se agregaron 10 al producto.";
	    }
	    return "No se pudieron agregar diez al producto.";
	}
	
	public String agregarAlCarrito(HttpSession sesion, ProductoDTO productoDTO) {
	    Optional<Producto> productoOptional = productoRepository.findByCodigo(productoDTO.getCodigo());

	    if (productoOptional.isPresent()) {
	        Producto producto = productoOptional.get();
	        VentaDTO ventaDTO = obtenerVentaEnSesion(sesion);

	        boolean productoAgregado = agregarProductoAlCarritoExistente(ventaDTO, producto);
	        if (!productoAgregado) {
	            DetVentaDTO nuevoDetalle = crearDetalleVenta(producto);
	            ventaDTO.getDetalles().add(nuevoDetalle);
	        }

	        actualizarTotalVenta(ventaDTO);

	        if (productoAgregado) {
	            return "Producto encontrado y cantidad incrementada en el carrito";
	        } else {
	            return "Producto encontrado y agregado al carrito";
	        }
	    } else {
	        return "Producto no encontrado";
	    }
	}



    private VentaDTO obtenerVentaEnSesion(HttpSession sesion) {
        if (sesion.getAttribute("miVenta") == null) {
            sesion.setAttribute("miVenta", new VentaDTO());
        }
        return (VentaDTO) sesion.getAttribute("miVenta");
    }

    private boolean agregarProductoAlCarritoExistente(VentaDTO ventaDTO, Producto producto) {
        for (DetVentaDTO detalle : ventaDTO.getDetalles()) {
            if (detalle.getProductoDTO().getUuid().equals(producto.getUuid())) {
                detalle.setCantidad(detalle.getCantidad() + 1);
                detalle.setSubtotal(detalle.getCantidad() * detalle.getPrecio());
                return true;
            }
        }
        return false;
    }

    private DetVentaDTO crearDetalleVenta(Producto producto) {
        DetVentaDTO nuevoDetalle = new DetVentaDTO();
        nuevoDetalle.setCantidad(1f);
        nuevoDetalle.setPrecio(producto.getPrecio());
        nuevoDetalle.setSubtotal(producto.getPrecio());
        nuevoDetalle.setProductoDTO(modelMapper.map(producto, ProductoDTO.class));
        return nuevoDetalle;
    }

    private void actualizarTotalVenta(VentaDTO ventaDTO) {
        float total = 0f;
        for (DetVentaDTO detalle : ventaDTO.getDetalles()) {
            total += detalle.getSubtotal();
        }
        ventaDTO.setTotal(total);
    }
    public List<Producto> buscarProductosPorQuery(String query) {
        return productoRepository.findByDescripcionContainingIgnoreCase(query);
    }
    public List<Producto> buscarPorDescripcion(String descripcion) {
        return productoRepository.findByDescripcionContainingIgnoreCase(descripcion);
    }
    public List<ProductoDTO> buscarProductosPorTermino(String termino) {
        List<Producto> productosEncontrados = productoRepository.findByDescripcionContainingIgnoreCase(termino);
        List<ProductoDTO> productosDTO = convertirAProductoDTO(productosEncontrados);
        return productosDTO;
    }

    private List<ProductoDTO> convertirAProductoDTO(List<Producto> productos) {
        List<ProductoDTO> productosDTO = new ArrayList<>();
        for (Producto producto : productos) {
            
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setCodigo(producto.getCodigo());
            productoDTO.setDescripcion(producto.getDescripcion());
            productoDTO.setPrecio(producto.getPrecio());
            productosDTO.add(productoDTO);
        }
        return productosDTO;
    }
}








