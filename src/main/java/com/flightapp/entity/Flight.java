package com.flightapp.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String fromLocation;
    private String toLocation;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private double price;

    private int totalSeats;
    private int availableSeats;

    @ManyToOne
    private Airline airline;
}
