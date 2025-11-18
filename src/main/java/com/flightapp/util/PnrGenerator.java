package com.flightapp.util;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PnrGenerator {

    public String generatePnr() {
        return "PNR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
