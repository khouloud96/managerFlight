/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.service;

import com.flight.managerFlight.entities.Line;
import com.flight.managerFlight.repository.LineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class LineService {
    @Autowired
    private LineRepository lineRepository;
    
    public Line getLine (Long id)
     {
         return lineRepository.findById(id).get();
     }
    
    public void deleteLine(Long id){
      lineRepository.deleteById(id);
    }
    
    public void updateLine(Line line) {
            lineRepository.save(line);
    }
 
    public List<Line> retrieveLine() {
        List<Line> lines = lineRepository.findAll();
            return lines;
    }
    
    public Line saveLine(Line line){
             return lineRepository.save(line);
    }
}
