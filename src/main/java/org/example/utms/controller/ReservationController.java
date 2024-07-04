package org.example.utms.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EntityNotFoundException;
import org.example.utms.model.Reservation;
import org.example.utms.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Map<String, Object> reservationData) {
        try {
            int userId = (Integer) reservationData.get("userId");
            int vehicleId = (Integer) reservationData.get("vehicleId");
            LocalDateTime startTime = LocalDateTime.parse((String) reservationData.get("startTime"));
            LocalDateTime endTime = LocalDateTime.parse((String) reservationData.get("endTime"));

            Reservation reservation = reservationService.createReservation(userId, vehicleId, startTime, endTime);
            return ResponseEntity.ok(reservation);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException | ClassCastException | NullPointerException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getUserReservations(@PathVariable int userId) {
        try {
            List<Reservation> reservations = reservationService.getUserReservations(userId);
            return ResponseEntity.ok(reservations);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{reservationId}/cancel")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long reservationId) {
        try {
            reservationService.cancelReservation(reservationId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}