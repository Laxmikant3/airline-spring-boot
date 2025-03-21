package com.airline.controller;
import java.util.List;

import com.airline.entity.Ticket;
import com.airline.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<String> createTicket(@RequestBody Ticket ticket) {
        ticketService.createTicket(ticket);
        return ResponseEntity.ok("Ticket created successfully!");
    }
    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long id) {
        boolean isDeleted = ticketService.deleteTicketById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Ticket deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Ticket not found!");
        }
    }
}
