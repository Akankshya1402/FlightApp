package com.flightapp.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightapp.dto.TicketBookingRequest;
import com.flightapp.entity.Ticket;
import com.flightapp.service.TicketService;

@WebMvcTest(TicketController.class)
public class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testBookTicket() throws Exception {

        TicketBookingRequest req = new TicketBookingRequest();
        req.setPassengerName("Rahul");
        req.setPassengerEmail("rahul@example.com");
        req.setPassengerAge(25);

        Ticket ticket = new Ticket();
        ticket.setPnr("PNR12345");

        when(ticketService.bookTicket(eq(1L), any())).thenReturn(ticket);

        mockMvc.perform(
                post("/api/v1.0/flight/booking/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(req))
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.pnr").value("PNR12345"));
    }
}
