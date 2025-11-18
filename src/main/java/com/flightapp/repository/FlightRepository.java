package com.flightapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByFromLocationAndToLocationAndDepartureTimeBetween(
            String fromLocation,
            String toLocation,
            LocalDateTime start,
            LocalDateTime end
    );
}
