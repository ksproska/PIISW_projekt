package com.example.backendapp.service;

import com.example.backendapp.model.common.Concession;
import com.example.backendapp.model.ticket.Ticket;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@Getter
@Setter
public class TicketInfo {
    private Long ticketId;
    private Date datetime;
    private Double price;
    private Concession concession;
    private String type;
    private boolean isActive;

    TicketInfo(Ticket ticket) {
        ticketId = ticket.getId();
        datetime = ticket.getClipTime();
        price = ticket.getPrice();
        concession = ticket.getConcession();
        type = ticket.type();
        isActive = ticket.verifyTicket(null, Calendar.getInstance().getTime());
    }

    public TicketInfo() {}
}
