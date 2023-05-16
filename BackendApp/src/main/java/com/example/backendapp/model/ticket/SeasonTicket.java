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
    public boolean verifyTicket(String tramId, Date dateOfTicketVerification)
    {
        Calendar calendar = Calendar.getInstance();
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
