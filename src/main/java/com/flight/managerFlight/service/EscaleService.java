/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.service;

import com.flight.managerFlight.entities.Airport;
import com.flight.managerFlight.entities.Escale;
import com.flight.managerFlight.repository.EscaleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class EscaleService {
    @Autowired
    private EscaleRepository escaleRepository;
    
    public Escale getEscale (Long id)
     {
         return escaleRepository.findById(id).get();
     }
    
    public void deleteEscale(Long id){
       escaleRepository.deleteById(id);
    }
    
    public void updateEscaleAirport(Escale escale,Airport airport) {
        escale.setAirport(airport);
            escaleRepository.save(escale);
    }
    
     public void updateEscaleDepartureTime(Escale escale,String departureTime ) {
        escale.setDepartureTime(departureTime);
            escaleRepository.save(escale);
    }
     
     public void updateEscaleArrivalTime(Escale escale,String arrivalTime ) {
        escale.setArrivalTime(arrivalTime);
            escaleRepository.save(escale);
    }
     
    public List<Escale> retrieveEscale() {
       List<Escale> escales = escaleRepository.findAll();
            return escales;
    }
    
    public Escale saveEscale(Escale escale){
             return escaleRepository.save(escale);
    }
}
