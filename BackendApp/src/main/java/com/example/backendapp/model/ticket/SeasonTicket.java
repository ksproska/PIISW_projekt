package com.example.backendapp.model.ticket;

import jakarta.persistence.Entity;

@Entity
public class SeasonTicket extends Ticket{

    private SeasonTicketDuration validityLengthInDays;
}
