package com.utsem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utsem.Repository.QuincenaRepository;
import com.utsem.Service.QuincenaService;
import com.utsem.model.Quincena;

@Controller
@RequestMapping("/quincena")
public class QuincenaController {

    @Autowired
    QuincenaRepository quincenaRepository;
    
    @Autowired
    QuincenaService quincenaService;

    @PostMapping("/guardarQuincena")
    public String guardarQuincena(@RequestBody Quincena quincena) {
        String mensaje = quincenaService.guardaQuincena(quincena);
        
        return mensaje;
    }   
}
