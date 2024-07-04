package org.example.utms.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.utms.model.Reservation;
import org.example.utms.model.ReservationStatus;
import org.example.utms.model.User;
import org.example.utms.model.Vehicle;
import org.example.utms.repository.ReservationRepository;
import org.example.utms.repository.UserRepository;
import org.example.utms.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }


    public Reservation createReservation(int userId, int vehicleId, LocalDateTime startTime, LocalDateTime endTime) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        if (!isVehicleAvailable(vehicle, startTime, endTime)) {
            throw new IllegalStateException("Vehicle is not available for the selected time period");
        }

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setVehicle(vehicle);
        reservation.setStartTime(startTime);
        reservation.setEndTime(endTime);
        reservation.setStatus(ReservationStatus.PENDING);

        return reservationRepository.save(reservation);
    }

    private boolean isVehicleAvailable(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        List<Reservation> overlappingReservations = reservationRepository
                .findByVehicleAndStartTimeBetween(vehicle, startTime, endTime);
        return overlappingReservations.isEmpty();
    }

    public List<Reservation> getUserReservations(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return reservationRepository.findByUser(user);
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);
    }
}