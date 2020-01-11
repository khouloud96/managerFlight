/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.controller;

import com.flight.managerFlight.entities.Airport;
import com.flight.managerFlight.service.AirportService;
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
@RequestMapping("/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;
    
    @GetMapping
    public List<Airport> getAirports() {
        return airportService.retrieveAirport();
    }

    @GetMapping("/{id}")
    public Airport getAirportByNum(@PathVariable Long id) {
        return airportService.getAirport(id);
    }

    @PostMapping
    public Airport saveAirport(Airport airport) {
        return airportService.saveAirport(airport);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
    
}
