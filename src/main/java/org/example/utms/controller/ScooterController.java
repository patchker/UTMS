package org.example.utms.controller;

import org.example.utms.model.Scooter;
import org.example.utms.repository.ScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scooter")
public class ScooterController {

    @Autowired
    private ScooterRepository scooterRepository;

    @PostMapping
    public Scooter createScooter(@RequestBody Scooter scooter) {

        return scooterRepository.save(scooter);
    }

    @GetMapping
    public List<Scooter> getAllScooter() {
        return scooterRepository.findAll();
    }
}

