package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.flightapp.dto.FlightSearchRequest;
import com.flightapp.entity.Airline;
import com.flightapp.entity.Flight;
import com.flightapp.service.FlightService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Add airline
    @PostMapping("/airline/add")
    public Airline addAirline(@Valid @RequestBody Airline airline) {
        return flightService.addAirline(airline);
    }

    // Add flight/inventory
    @PostMapping("/airline/inventory/add")
    public Flight addFlight(@Valid @RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    // Search flights
    @PostMapping("/search")
    public List<Flight> searchFlights(@Valid @RequestBody FlightSearchRequest request) {
        return flightService.searchFlights(request);
    }
}
