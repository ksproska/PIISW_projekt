package com.example.backendapp.model.offer;

import com.example.backendapp.model.ticket.SeasonTicketDuration;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OfferSeasonTicket extends Offer {
    private SeasonTicketDuration validityLengthInDays;
}
