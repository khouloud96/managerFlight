/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.service;

import com.flight.managerFlight.entities.Client;
import com.flight.managerFlight.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
   
    public List<Client> getClients() {
        return this.clientRepository.findAll();
    }

    public Client getClientById(String id) {
        return clientRepository.findById(id).get();
    }
    
    public void deleteClient(String id) {
        Client client = clientRepository.findById(id).get();

        clientRepository.delete(client);
    }
}
