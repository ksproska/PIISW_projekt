package com.example.backendapp.service;

import com.example.backendapp.model.common.TicketStatus;
import com.example.backendapp.model.ticket.Ticket;
import com.example.backendapp.repository.OfferRepository;
import com.example.backendapp.repository.TicketRepository;
import com.example.backendapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase
@TestPropertySource("classpath:test.properties")
public class TicketServiceTest
{
    private TicketRepository ticketRepository;
    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        ticketRepository = Mockito.mock(TicketRepository.class);
        offerRepository = Mockito.mock(OfferRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        ticketService = new TicketService(ticketRepository, offerRepository, userRepository);
    }

    @Test
    public void testGetTicketById_ExistingTicket() {
        long ticketId = 123L;
        Ticket ticket = Mockito.mock(Ticket.class);
        when(ticketRepository.findById(ticketId)).thenReturn(Optional.of(ticket));

        Optional<Ticket> result = ticketService.getTicketById(ticketId);

        assertTrue(result.isPresent());
        assertEquals(ticket, result.get());
    }

    @Test
    public void testGetTicketById_NonExistingTicket() {
        long ticketId = 123L;
        when(ticketRepository.findById(ticketId)).thenReturn(Optional.empty());

        Optional<Ticket> result = ticketService.getTicketById(ticketId);

        assertFalse(result.isPresent());
    }

    @Test
    public void testIsActiveForTram_TicketNotFound() {
        long ticketId = 123L;
        String tramId = "TRAM-001";
        when(ticketRepository.findById(ticketId)).thenReturn(Optional.empty());

        String result = ticketService.isActiveForTram(ticketId, tramId);

        assertEquals(TicketStatus.NOT_FOUND.getStatus(), result);
    }

    @Test
    public void testIsActiveForTram_TicketNotClipped() {
        long ticketId = 123L;
        String tramId = "TRAM-001";
        Ticket ticket = Mockito.mock(Ticket.class);
        when(ticketRepository.findById(ticketId)).thenReturn(Optional.of(ticket));
        when(ticket.getClipTime()).thenReturn(null);

        String result = ticketService.isActiveForTram(ticketId, tramId);

        assertEquals(TicketStatus.NOT_CLIPPED.getStatus(), result);
    }

    @Test
    public void testIsActiveForTram_InvalidTicket() {
        long ticketId = 123L;
        String tramId = "TRAM-001";
        Date currentTime = new Date();
        Ticket ticket = Mockito.mock(Ticket.class);
        when(ticketRepository.findById(ticketId)).thenReturn(Optional.of(ticket));
        when(ticket.getClipTime()).thenReturn(currentTime);
        when(ticket.isActiveForTram(tramId, currentTime)).thenReturn(false);

        String result = ticketService.isActiveForTram(ticketId, tramId);

        assertEquals(TicketStatus.INVALID.getStatus(), result);
    }

    @Test
    public void testGetTicketInfo_UserNotFound() {
        long userId = 123L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> ticketService.getTicketInfo(userId));
    }
}
