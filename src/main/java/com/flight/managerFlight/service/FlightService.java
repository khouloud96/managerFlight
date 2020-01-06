/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.service;

import com.flight.managerFlight.entities.Flight;
import com.flight.managerFlight.repository.FlightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightByNum(Long id) {
        return flightRepository.findById(id).get();
    }
    
    public Flight createFlight(Flight flight){
        return flightRepository.save(flight);
    }
    
     public void deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Flight with id " + id));

        flightRepository.delete(flight);
    }
}
