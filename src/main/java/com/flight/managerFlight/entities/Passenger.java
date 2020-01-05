/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author DELL
 */
@Data
@NoArgsConstructor
@Entity
public class Passenger {
    @Id
    private String NumPassport;
    
    private String FirstName;
    
    private String LastName;
    
    private String sexe;
    
    private int age;
    
    private String email;
    
}
