package com.example.backendapp.model.ticket;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class SingleTicket extends Ticket{

    private String tramId;

    @Override
    public boolean isActiveForTram(String tramId, Date dateOfTicketVerification) {
        return  this.tramId.equalsIgnoreCase(tramId) && isActive(dateOfTicketVerification);
    }

    @Override
    public boolean isActive(Date dateOfTicketVerification) {
        if (getClipTime() == null) return false;
        return this.getClipTime().before(dateOfTicketVerification) &&
                this.getClipTime().getDate() == dateOfTicketVerification.getDate();
    }

    @Override
    public String type() {
        return "single ticket";
    }
}
