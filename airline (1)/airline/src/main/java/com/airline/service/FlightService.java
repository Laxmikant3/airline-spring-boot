package com.airline.service;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.airline.entity.Flight;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final List<Flight> flightList = new ArrayList<>();

    @PostConstruct
    public void initializeFlights() {
        flightList.add(new Flight(101L, "IndiGo Airlines", "IG-456", "Chennai", "Pune", 5200.00));
        flightList.add(new Flight(102L, "SpiceJet", "SJ-789", "Hyderabad", "Goa", 4800.00));
        flightList.add(new Flight(1L, "Indigo", "6E-123", "Mumbai", "Delhi", 4500.00));
        flightList.add(new Flight(2L, "Air India", "AI-202", "Bangalore", "Kolkata", 6000.00));
        flightList.add(new Flight(3L, "Fly Emirates", "FE-403", "Dubai", "India", 25000.00));
        flightList.add(new Flight(4L, "Air India", "AI-206", "Nagpur", "Kolkata", 10000.00));
        flightList.add(new Flight(5L, "Air India", "AI-203", "Mumbai", "Pune", 5000.00));
    }

    public List<Flight> fetchAllFlights(String sort) {
        if ("desc".equalsIgnoreCase(sort)) {
            return flightList.stream()
                    .sorted(Comparator.comparingDouble(Flight::getTicketPrice).reversed())
                    .collect(Collectors.toList());
        }
        return flightList.stream()
                .sorted(Comparator.comparingDouble(Flight::getTicketPrice))
                .collect(Collectors.toList());
    }

    public Optional<Flight> retrieveFlightById(Long flightId) {
        return flightList.stream().filter(flight -> flight.getFlightId().equals(flightId)).findFirst();
    }

    public void registerNewFlight(Flight newFlight) {
        flightList.add(newFlight);
    }
}

