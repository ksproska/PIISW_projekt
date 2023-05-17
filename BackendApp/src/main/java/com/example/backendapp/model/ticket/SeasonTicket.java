package com.example.backendapp.model.ticket;

import com.example.backendapp.model.common.SeasonTicketDuration;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
public class SeasonTicket extends Ticket{

    private SeasonTicketDuration validityLengthInDays;

    @Override
    public boolean isActiveForTram(String tramId, Date dateOfTicketVerification) {
        return isActive(dateOfTicketVerification);
    }

    @Override
    public void activeForTram(String tramId, Date dateOfActivation) {
        setClipTime(dateOfActivation);
    }

    @Override
    public boolean isActive(Date dateOfTicketVerification) {
        if (this.getClipTime() == null) return false;
        var calendar = Calendar.getInstance();
        calendar.setTime(this.getClipTime());
        calendar.add(Calendar.DATE, this.validityLengthInDays.getValue());
        var dateLimit = calendar.getTime();

        return  this.getClipTime().before(dateOfTicketVerification) &&
                dateOfTicketVerification.before(dateLimit);
    }

    @Override
    public String type() {
        return validityLengthInDays.name();
    }
}
