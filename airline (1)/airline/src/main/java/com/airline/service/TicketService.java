package com.airline.service;

import com.airline.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final List<Ticket> ticketList = new ArrayList<>();

    // Initializing with some hardcoded tickets
    public TicketService() {
        ticketList.add(new Ticket(101L, "John Doe", "AI123", 500.0));
        ticketList.add(new Ticket(102L, "Jane Smith", "BA456", 750.0));
        ticketList.add(new Ticket(103L, "Mike Johnson", "DL789", 620.0));
        ticketList.add(new Ticket(104L, "Emma Wilson", "EK321", 890.0));
        ticketList.add(new Ticket(105L, "Robert Brown", "QR654", 720.0));
    }

    public Ticket createTicket(Ticket ticket) {
        ticketList.add(ticket);
        return ticket;
    }

    public Optional<Ticket> getTicketById(Long ticketId) {
        return ticketList.stream()
                .filter(ticket -> ticket.getTicketId().equals(ticketId))
                .findFirst();
    }

    public List<Ticket> getAllTickets() {
        return ticketList;
    }

    public boolean deleteTicketById(Long ticketId) {
        return ticketList.removeIf(ticket -> ticket.getTicketId().equals(ticketId));
    }
}
