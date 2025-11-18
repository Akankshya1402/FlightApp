package com.flightapp.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dto.FlightSearchRequest;
import com.flightapp.entity.Airline;
import com.flightapp.entity.Flight;
import com.flightapp.exception.ResourceNotFoundException;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.FlightRepository;
import com.flightapp.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private AirlineRepository airlineRepo;

    @Autowired
    private FlightRepository flightRepo;

    @Override
    public Airline addAirline(Airline airline) {
        return airlineRepo.save(airline);
    }

    @Override
    public Flight addFlight(Flight flight) {
        Airline airline = airlineRepo.findById(flight.getAirline().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Airline not found"));

        flight.setAirline(airline);
        return flightRepo.save(flight);
    }

    @Override
    public List<Flight> searchFlights(FlightSearchRequest request) {

        LocalDateTime dateStart = request.getDate().atStartOfDay();
        LocalDateTime dateEnd   = request.getDate().atTime(23, 59, 59);

        return flightRepo.findByFromLocationAndToLocationAndDepartureTimeBetween(
                request.getFromLocation(),
                request.getToLocation(),
                dateStart,
                dateEnd
        );
    }

    @Override
    public Flight getFlightById(Long id) {
        return flightRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found"));
    }
}



