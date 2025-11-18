package com.flightapp.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {

    private String pnr;
    private Long flightId;
    private String flightNumber;

    private String passengerName;
    private String passengerEmail;

    private LocalDateTime bookingTime;
    private String status;
}
