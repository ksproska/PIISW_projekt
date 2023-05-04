package com.example.backendapp.service;

import com.example.backendapp.model.ticket.Ticket;
import com.example.backendapp.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Optional<Ticket> getTicketById(long id) { return ticketRepository.findById(id); }

    public boolean verifyTicket(long id, String tramId) throws NoSuchElementException
    {
        // TODO validation
        var ticket = ticketRepository.findById(id);
        if (ticket.isEmpty()) throw new NoSuchElementException("Ticket with id '" + id + "' not found");
        return ticket.get().verifyTicket(tramId, Calendar.getInstance().getTime());
    }
}
