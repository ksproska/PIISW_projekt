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
    public boolean isActiveForTram(String tramId, Date dateOfTicketVerification) {
        return isActive(dateOfTicketVerification);
    }

    @Override
    public boolean isActive(Date dateOfTicketVerification) {
        if (this.getClipTime() == null) return false;
        var dateLimit = activeTill();

        return  this.getClipTime().before(dateOfTicketVerification) &&
                dateOfTicketVerification.before(dateLimit);
    }

    @Override
    public String type() {
        return validityLengthInMinutes.name();
    }

    @Override
    public Date activeTill() {
        var calendar = Calendar.getInstance();
        calendar.setTime(this.getClipTime());
        calendar.add(Calendar.MINUTE, this.validityLengthInMinutes.getValue());
        return calendar.getTime();
    }
}
