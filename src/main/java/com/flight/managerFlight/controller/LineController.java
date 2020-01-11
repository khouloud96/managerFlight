/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.controller;

import com.flight.managerFlight.entities.Line;
import com.flight.managerFlight.service.LineService;
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
@RequestMapping("/lines")
public class LineController {
    @Autowired
    private LineService lineService;
    
    @GetMapping
    public List<Line> getLines() {
        return lineService.retrieveLine();
    }

    @GetMapping("/{id}")
    public Line getLine(@PathVariable Long id) {
        return lineService.getLine(id);
    }

    @PostMapping
    public Line saveLine(Line line) {
        return lineService.saveLine(line);
    }

    @DeleteMapping("/{id}")
    public void deleteLine(@PathVariable Long id) {
        lineService.deleteLine(id);
    }
    
}
