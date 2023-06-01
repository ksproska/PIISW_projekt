package com.example.backendapp.service;

import com.example.backendapp.model.ticket.SingleTicket;
import com.example.backendapp.model.ticket.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicketInfoTest {

    private TicketInfo ticketInfo;

    @BeforeEach
    public void setUp() {
        Ticket ticket = Mockito.mock(Ticket.class);
        Mockito.when(ticket.getId()).thenReturn(123L);
        Mockito.when(ticket.getClipTime()).thenReturn(new Date());
        Mockito.when(ticket.getPrice()).thenReturn(10.0);
        Mockito.when(ticket.type()).thenReturn("SingleTicket");
        Mockito.when(ticket.isActive(Mockito.any())).thenReturn(true);
        Mockito.when(ticket.activeTill()).thenReturn(getFutureDate());
        ticketInfo = new TicketInfo(ticket);
    }

    @Test
    public void testTicketId() {
        assertEquals(123L, ticketInfo.getTicketId());
    }

    @Test
    void testPrice() {
        assertEquals(10.0, ticketInfo.getPrice());
    }

    @Test
    void testType() {
        assertEquals("SingleTicket", ticketInfo.getType());
    }

    @Test
    void testIsActive() {
        assertTrue(ticketInfo.isActive());
    }

    @Test
    void testTramId() {
        SingleTicket singleTicket = Mockito.mock(SingleTicket.class);
        Mockito.when(singleTicket.getTramId()).thenReturn("TRAM-001");
        TicketInfo ticketInfo = new TicketInfo(singleTicket);
        assertEquals("TRAM-001", ticketInfo.getTramId());
    }

    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }
}
