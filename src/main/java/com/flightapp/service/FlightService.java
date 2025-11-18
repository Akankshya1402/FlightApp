package com.flightapp.service;

import java.util.List;

import com.flightapp.dto.FlightSearchRequest;
import com.flightapp.entity.Airline;
import com.flightapp.entity.Flight;

public interface FlightService {

    Airline addAirline(Airline airline);

    Flight addFlight(Flight flight);

    List<Flight> searchFlights(FlightSearchRequest request);

    Flight getFlightById(Long id);
}
