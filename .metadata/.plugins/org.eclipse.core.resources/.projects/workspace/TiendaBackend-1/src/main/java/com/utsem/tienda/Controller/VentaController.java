package com.utsem.tienda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utsem.tienda.DTO.ProductoDTO;
import com.utsem.tienda.DTO.VentaDTO;
import com.utsem.tienda.Service.VentaService;
import com.utsem.tienda.repository.ProductoRepository;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("ventas")
public class VentaController {
	@Autowired
	VentaService ventaService;
	@Autowired
	ProductoRepository productoRepository;
	
	@PostMapping("buscarCodigo")
	public String buscaCodigo(HttpSession sesion, @RequestBody ProductoDTO productoDTO) {	
		System.out.println("JSESSIONID: "+sesion.getId());
		System.out.println("codigo a buscar: "+productoDTO.getCodigo());
		return ventaService.buscaProductoPorCodigo(sesion, productoDTO);
	}
	@PostMapping("consultarVenta")
	public VentaDTO consultarVenta(HttpSession sesion) {	
		System.out.println("JSESSIONID: "+sesion.getId());
		return ventaService.consultaVenta(sesion);
	}
	@PostMapping("limpiarVenta")
	public String limpiaVenta(HttpSession sesion) {	
		System.out.println("JSESSIONID: "+sesion.getId());
		return ventaService.limpiaVenta(sesion);
	}
	@PostMapping("eliminarDetalle/{pos}")
	public String eliminaDetalle(HttpSession sesion, @PathVariable int pos) {
		System.out.println("JSESSIONID: "+sesion.getId());
		return ventaService.eliminarDetalle(sesion, pos);
	}
	@PostMapping("guardarVenta")
	public String guardaVenta(HttpSession sesion) {	
		System.out.println("JSESSIONID: "+sesion.getId());
		return ventaService.guardaVenta(sesion);
	}
	@PostMapping("eliminarUno/{pos}")
	public String eliminarUno(HttpSession sesion, @PathVariable int pos) {
	    System.out.println("JSESSIONID: " + sesion.getId());
	    return ventaService.eliminarUno(sesion, pos);
	}

	@PostMapping("Uno/{pos}")
	public String agregarUno(HttpSession sesion, @PathVariable int pos) {
	    System.out.println("JSESSIONID: " + sesion.getId());
	    return ventaService.Uno(sesion, pos);
	}

	@PostMapping("Cinco/{pos}")
	public String agregarCinco(HttpSession sesion, @PathVariable int pos) {
	    System.out.println("JSESSIONID: " + sesion.getId());
	    return ventaService.Cinco(sesion, pos);
	}

	@PostMapping("Diez/{pos}")
	public String agregarDiez(HttpSession sesion, @PathVariable int pos) {
	    System.out.println("JSESSIONID: " + sesion.getId());
	    return ventaService.Diez(sesion, pos);
    }
	@PostMapping("agregarAlCarrito")
	public String agregarAlCarrito(@RequestBody ProductoDTO productoDTO, HttpSession sesion) {
	    String mensaje = ventaService.agregarAlCarrito(sesion, productoDTO);
	    System.out.println(mensaje);

	    if (mensaje.equals("Producto encontrado y agregado al carrito") || mensaje.equals("Producto encontrado y cantidad incrementada en el carrito")) {
	        return "{\"mensaje\": \"" + mensaje + "\"}";
	    } else {
	        return "{\"mensaje\": \"" + mensaje + "\"}";
	    }
	}
	@GetMapping("/buscarPorTermino")
    public ResponseEntity<List<ProductoDTO>> buscarPorTermino(@RequestParam String termino) {
        List<ProductoDTO> productosEncontrados = ventaService.buscarProductosPorTermino(termino);
        return ResponseEntity.ok(productosEncontrados);
    }
}
