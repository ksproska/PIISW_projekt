package com.example.backendapp.service;

import com.example.backendapp.model.offer.OfferCommuterPass;
import com.example.backendapp.model.offer.OfferSeasonTicket;
import com.example.backendapp.model.offer.OfferSingleTicket;
import com.example.backendapp.repository.OfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OfferServiceTest {

    private OfferRepository offerRepository;
    private OfferService offerService;

    @BeforeEach
    public void setUp() {
        offerRepository = Mockito.mock(OfferRepository.class);
        offerService = new OfferService(offerRepository);
    }

    @Test
    public void testGetAllOfferSingleTickets() {
        OfferSingleTicket offer1 = Mockito.mock(OfferSingleTicket.class);
        OfferSingleTicket offer2 = Mockito.mock(OfferSingleTicket.class);
        List<OfferSingleTicket> offerSingleTickets = Arrays.asList(offer1, offer2);
        when(offerRepository.findAllOfferSingleTickets()).thenReturn(offerSingleTickets);

        List<OfferSingleTicket> result = offerService.getAllOfferSingleTickets();

        assertEquals(offerSingleTickets, result);
    }

    @Test
    public void testGetAllOfferSeasonTickets() {
        OfferSeasonTicket offer1 = Mockito.mock(OfferSeasonTicket.class);
        OfferSeasonTicket offer2 = Mockito.mock(OfferSeasonTicket.class);
        List<OfferSeasonTicket> offerSeasonTickets = Arrays.asList(offer1, offer2);
        when(offerRepository.findAllOfferSeasonTickets()).thenReturn(offerSeasonTickets);

        List<OfferSeasonTicket> result = offerService.getAllOfferSeasonTickets();

        assertEquals(offerSeasonTickets, result);
    }

    @Test
    public void testGetAllOfferCommuterPasses() {
        OfferCommuterPass offer1 = Mockito.mock(OfferCommuterPass.class);
        OfferCommuterPass offer2 = Mockito.mock(OfferCommuterPass.class);
        List<OfferCommuterPass> offerCommuterPasses = Arrays.asList(offer1, offer2);
        when(offerRepository.findAllOfferCommuterPasses()).thenReturn(offerCommuterPasses);

        List<OfferCommuterPass> result = offerService.getAllOfferCommuterPasses();

        assertEquals(offerCommuterPasses, result);
    }
}
