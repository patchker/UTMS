package org.example.utms.repository;

import org.example.utms.model.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterRepository extends JpaRepository<Scooter, Integer> {
}