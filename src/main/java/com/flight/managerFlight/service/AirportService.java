/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.service;

import com.flight.managerFlight.entities.Airport;
import com.flight.managerFlight.repository.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    
    public Airport getAirport (Long id)
     {
         return airportRepository.findById(id).get();
     }
    public void deleteAirport(Long id){
      airportRepository.deleteById(id);}
    
    public void updateAirport(Airport airport) {
            airportRepository.save(airport);
    }
    
    public List<Airport> retrieveAirport() {
        List<Airport> airports = airportRepository.findAll();
            return airports;
    }
    
    public Airport saveAirport(Airport airport){
            return airportRepository.save(airport);
    }
    
}
