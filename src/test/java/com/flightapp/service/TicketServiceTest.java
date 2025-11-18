package com.flightapp.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.flightapp.dto.TicketBookingRequest;
import com.flightapp.entity.Flight;
import com.flightapp.entity.Ticket;
import com.flightapp.exception.ResourceNotFoundException;
import com.flightapp.repository.FlightRepository;
import com.flightapp.repository.TicketRepository;
import com.flightapp.service.impl.TicketServiceImpl;

public class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepo;

    @Mock
    private FlightRepository flightRepo;

    @InjectMocks
    private TicketServiceImpl ticketService;

    public TicketServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTicketByPnr_Found() {
        Ticket ticket = new Ticket();
        ticket.setPnr("PNR123");

        when(ticketRepo.findByPnr("PNR123")).thenReturn(Optional.of(ticket));

        Ticket found = ticketService.getTicketByPnr("PNR123");
        assertNotNull(found);
    }

    @Test
    void testGetTicketByPnr_NotFound() {
        when(ticketRepo.findByPnr("PNR000")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> ticketService.getTicketByPnr("PNR000"));
    }
}
