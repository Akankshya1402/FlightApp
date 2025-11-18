package com.flightapp.service;

import java.util.List;

import com.flightapp.dto.TicketBookingRequest;
import com.flightapp.entity.Ticket;

public interface TicketService {

    Ticket bookTicket(Long flightId, TicketBookingRequest request);

    Ticket getTicketByPnr(String pnr);

    List<Ticket> getBookingHistory(String email);

    void cancelTicket(String pnr);
}
