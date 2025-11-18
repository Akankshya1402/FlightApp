package com.flightapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FlightSearchRequest {

    @NotNull(message = "From location is required")
    private String fromLocation;

    @NotNull(message = "To location is required")
    private String toLocation;

    @NotNull(message = "Date is required")
    private LocalDate date;
}
