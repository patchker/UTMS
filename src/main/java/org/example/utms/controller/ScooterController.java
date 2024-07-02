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

        Scooter s1 = new Scooter(6, "test scooter", "scooter", "Lime", "LT_20", "electric", 222, 2, 100, 0, 1, 1);
        scooterRepository.save(s1);
        return s1;
    }

    @GetMapping
    public List<Scooter> getAllScooter() {
        return scooterRepository.findAll();
    }
}