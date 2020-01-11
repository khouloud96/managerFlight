/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.controller;

import com.flight.managerFlight.entities.Escale;
import com.flight.managerFlight.service.EscaleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/escale")
public class EscaleController {
    @Autowired
    private EscaleService escaleService;
    
    @GetMapping
    public List<Escale> getEscales() {
        return escaleService.retrieveEscale();
    }

    @GetMapping("/{id}")
    public Escale getEscale(@PathVariable Long id) {
        return escaleService.getEscale(id);
    }

    @PostMapping
    public Escale saveEscale(Escale escale) {
        return escaleService.saveEscale(escale);
    }

    @DeleteMapping("/{id}")
    public void deleteEscale(@PathVariable Long id) {
        escaleService.deleteEscale(id);
    }
    
}
