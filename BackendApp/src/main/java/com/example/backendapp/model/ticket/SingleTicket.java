package com.example.backendapp.model.ticket;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class SingleTicket extends Ticket{

    private String tramId;

    @Override
    public boolean verifyTicket(String tramId, Date dateOfTicketVerification)
    {
        return  this.tramId.equalsIgnoreCase(tramId) &&
                this.getClipTime().before(dateOfTicketVerification) &&
                this.getClipTime().getDate() == dateOfTicketVerification.getDate();
    }
}
