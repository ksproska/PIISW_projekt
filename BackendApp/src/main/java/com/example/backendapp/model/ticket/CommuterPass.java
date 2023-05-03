package com.example.backendapp.model.ticket;

import com.example.backendapp.model.common.CommuterPassDuration;
import jakarta.persistence.Entity;

@Entity
public class CommuterPass extends Ticket {

    private CommuterPassDuration validityLengthInMinutes;
}
