package com.airline.controller;

import com.airline.entity.Flight;
import com.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights") // Use '/flights' as base path
public class FlightController {
    @Autowired
    private FlightService flightService;

    // GET all flights with optional sorting
    @GetMapping
    public List<Flight> fetchFlightDetails(@RequestParam(required = false, defaultValue = "asc") String sort) {
        return flightService.fetchAllFlights(sort);
    }


    // GET flight by ID
    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> fetchFlightById(@PathVariable Long flightId) {
        Optional<Flight> flightData = flightService.retrieveFlightById(flightId);
        return flightData.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET flight schedules by flight ID with optional date filtering
    @GetMapping("/{flightId}/schedules")
    public ResponseEntity<?> fetchFlightSchedules(@PathVariable Long flightId, @RequestParam(required = false) String dates) {
        return ResponseEntity.ok("Fetching schedules for Flight ID: " + flightId + (dates != null ? " on date: " + dates : ""));
    }

    // POST create a flight
    @PostMapping
    public ResponseEntity<String> saveFlight(@RequestBody Flight flightDetails) {
        flightService.registerNewFlight(flightDetails);
        return ResponseEntity.ok("Flight successfully added!");
    }
}
