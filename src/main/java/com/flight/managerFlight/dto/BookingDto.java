/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.dto;

import com.flight.managerFlight.entities.Flight;
import com.flight.managerFlight.entities.Passenger;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author DELL
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;
    
    private Passenger passenger;
  
    private Flight flight;
    
    private int seats;
    
    private BigDecimal TotPrice;
}
