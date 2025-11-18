package com.flightapp.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketBookingRequest {

    @NotBlank
    private String passengerName;

    @Email
    private String passengerEmail;

    @Min(1)
    private int passengerAge;
}

