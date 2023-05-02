package com.example.backendapp.model.ticket;

import jakarta.persistence.Entity;

@Entity
public class CommuterPass extends Ticket {

    private CommuterPassDuration validityLengthInMinutes;
}
