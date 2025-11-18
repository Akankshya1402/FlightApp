package com.flightapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dto.TicketBookingRequest;
import com.flightapp.entity.Flight;
import com.flightapp.entity.Ticket;
import com.flightapp.exception.ResourceNotFoundException;
import com.flightapp.repository.FlightRepository;
import com.flightapp.repository.TicketRepository;
import com.flightapp.service.TicketService;
import com.flightapp.util.PnrGenerator;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepo;

    @Autowired
    private FlightRepository flightRepo;

    @Autowired
    private PnrGenerator pnrGenerator;

    @Override
    public Ticket bookTicket(Long flightId, TicketBookingRequest request) {

        Flight flight = flightRepo.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found"));

        if (flight.getAvailableSeats() <= 0) {
            throw new RuntimeException("No seats available");
        }

        Ticket ticket = new Ticket();
        ticket.setPassengerName(request.getPassengerName());
        ticket.setPassengerEmail(request.getPassengerEmail());
        ticket.setPassengerAge(request.getPassengerAge());
        ticket.setFlight(flight);
        ticket.setPnr(pnrGenerator.generatePnr());

        // reduce seat count
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepo.save(flight);

        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket getTicketByPnr(String pnr) {
        return ticketRepo.findByPnr(pnr)
                .orElseThrow(() -> new ResourceNotFoundException("PNR not found: " + pnr));
    }

    @Override
    public List<Ticket> getBookingHistory(String email) {
        return ticketRepo.findByPassengerEmail(email);
    }

    @Override
    public void cancelTicket(String pnr) {

        Ticket ticket = ticketRepo.findByPnr(pnr)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot cancel. PNR not found"));

        Flight flight = ticket.getFlight();
        flight.setAvailableSeats(flight.getAvailableSeats() + 1);
        flightRepo.save(flight);

        ticketRepo.delete(ticket);
    }
}

