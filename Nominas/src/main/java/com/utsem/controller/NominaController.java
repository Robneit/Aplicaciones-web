package com.utsem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utsem.Service.NominaService;
import com.utsem.model.Nomina; // Asegúrate de importar la clase NominaDTO correctamente

@RestController
@RequestMapping("/nominas")
public class NominaController {

    @Autowired
    private NominaService nominaService;

    @GetMapping("/{codigoEmpleado}")
    public ResponseEntity<List<Nomina>> obtenerNominasPorEmpleado(@PathVariable Long codigoEmpleado) {
        List<Nomina> nominas = nominaService.obtenerNominasPorEmpleado(codigoEmpleado);
        return ResponseEntity.ok(nominas);
    }
}
