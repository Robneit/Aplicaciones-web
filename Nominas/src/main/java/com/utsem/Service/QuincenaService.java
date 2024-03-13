package com.utsem.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsem.Repository.QuincenaRepository;
import com.utsem.model.Quincena;

@Service
public class QuincenaService {
    
    @Autowired
    private QuincenaRepository quincenaRepository;

    public String guardaQuincena(Quincena quincena) {
        quincenaRepository.save(quincena);
        return "Quincena Guardada";
    }
}
