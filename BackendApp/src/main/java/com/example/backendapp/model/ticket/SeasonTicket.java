package com.example.backendapp.model.ticket;

import com.example.backendapp.model.common.SeasonTicketDuration;
import jakarta.persistence.Entity;

@Entity
public class SeasonTicket extends Ticket{

    private SeasonTicketDuration validityLengthInDays;
}
