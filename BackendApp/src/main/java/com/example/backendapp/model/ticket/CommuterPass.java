package com.example.backendapp.model.ticket;

import com.example.backendapp.model.common.CommuterPassDuration;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Calendar;

@Entity
@Getter
@Setter
public class CommuterPass extends Ticket {

    private CommuterPassDuration validityLengthInMinutes;

    @Override
    public boolean verifyTicket(String tramId, Date dateOfTicketVerification)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getClipTime());
        calendar.add(Calendar.MINUTE, this.validityLengthInMinutes.getValue());
        var dateLimit = calendar.getTime();

        return  this.getClipTime().before(dateOfTicketVerification) &&
                dateOfTicketVerification.before(dateLimit);
    }
}
