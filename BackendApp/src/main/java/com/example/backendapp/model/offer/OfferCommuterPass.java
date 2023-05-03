package com.example.backendapp.model.offer;

import com.example.backendapp.model.ticket.CommuterPassDuration;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OfferCommuterPass extends Offer {
    private CommuterPassDuration validityLengthInMinutes;
}
