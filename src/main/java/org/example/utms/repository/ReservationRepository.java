package org.example.utms.repository;

import org.example.utms.model.Reservation;
import org.example.utms.model.User;
import org.example.utms.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByVehicleAndStartTimeBetween(Vehicle vehicle, LocalDateTime start, LocalDateTime end);
    List<Reservation> findByUser(User user);
}
