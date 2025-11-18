package com.flightapp.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.flightapp.entity.Airline;
import com.flightapp.entity.Flight;
import com.flightapp.exception.ResourceNotFoundException;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.FlightRepository;
import com.flightapp.service.impl.FlightServiceImpl;

public class FlightServiceTest {

    @Mock
    private AirlineRepository airlineRepo;

    @Mock
    private FlightRepository flightRepo;

    @InjectMocks
    private FlightServiceImpl flightService;

    public FlightServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFlightById_Found() {
        Flight flight = new Flight();
        flight.setId(1L);

        when(flightRepo.findById(1L)).thenReturn(Optional.of(flight));

        Flight found = flightService.getFlightById(1L);
        assertNotNull(found);
    }

    @Test
    void testGetFlightById_NotFound() {
        when(flightRepo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                     () -> flightService.getFlightById(1L));
    }
}
