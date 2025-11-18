package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flightapp.dto.TicketBookingRequest;
import com.flightapp.entity.Ticket;
import com.flightapp.service.TicketService;

@RestController
@RequestMapping("/api/v1.0/flight")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // BOOK TICKET
    @PostMapping("/booking/{flightId}")
    public ResponseEntity<Ticket> bookTicket(
            @PathVariable Long flightId,
            @RequestBody TicketBookingRequest request) {
        return ResponseEntity.ok(ticketService.bookTicket(flightId, request));
    }

    // GET TICKET BY PNR
    @GetMapping("/ticket/{pnr}")
    public ResponseEntity<Ticket> getTicket(@PathVariable String pnr) {
        return ResponseEntity.ok(ticketService.getTicketByPnr(pnr));
    }

    // BOOKING HISTORY
    @GetMapping("/booking/history/{email}")
    public ResponseEntity<List<Ticket>> bookingHistory(@PathVariable String email) {
        return ResponseEntity.ok(ticketService.getBookingHistory(email));
    }

    // CANCEL TICKET
    @DeleteMapping("/booking/cancel/{pnr}")
    public ResponseEntity<String> cancelTicket(@PathVariable String pnr) {
        ticketService.cancelTicket(pnr);
        return ResponseEntity.ok("Ticket cancelled successfully");
    }
}

