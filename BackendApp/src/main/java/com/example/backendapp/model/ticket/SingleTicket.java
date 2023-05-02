package com.example.backendapp.model.ticket;

import jakarta.persistence.Entity;

@Entity
public class SingleTicket extends Ticket{

    private String tramId;
}
