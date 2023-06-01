package com.example.backendapp.service;

import com.example.backendapp.repository.OfferRepository;
import com.example.backendapp.repository.TicketRepository;
import com.example.backendapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase
@TestPropertySource("classpath:test.properties")
public class TicketServiceTest
{
    @InjectMocks
    private TicketService ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private OfferRepository offerRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldHaveAtLeastOneTicket()
    {
        // given
        var userWithTickets = userRepository.findByUsername("Franciszek");
        var userId = userWithTickets.get().getId();

        // when
        //when(userRepository.findById(anyLong())).thenReturn(userWithTickets); // TODO nie bangla
        var listOfTickets = ticketService.getTicketInfo(userWithTickets.get().getId());

        // then
        assertNotNull(listOfTickets);
        assertTrue(listOfTickets.size() > 0);
    }
}
