package com.example.backendapp.controller;

import com.example.backendapp.controller.api.OfferController;
import com.example.backendapp.model.offer.OfferCommuterPass;
import com.example.backendapp.model.offer.OfferSeasonTicket;
import com.example.backendapp.model.offer.OfferSingleTicket;
import com.example.backendapp.service.OfferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

public class OfferControllerTest {

    private OfferController offerController;

    @Mock
    private OfferService offerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        offerController = new OfferController(offerService);
    }

    @Test
    public void testGetOfferSingleTickets() {
        List<OfferSingleTicket> expectedOffers = new ArrayList<>();
        expectedOffers.add(new OfferSingleTicket());
        expectedOffers.add(new OfferSingleTicket());

        when(offerService.getAllOfferSingleTickets()).thenReturn(expectedOffers);

        List<OfferSingleTicket> result = offerController.getOfferSingleTickets();

        assertEquals(expectedOffers, result);
    }

    @Test
    public void testGetAllOfferCommuterPasses() {
        List<OfferCommuterPass> expectedOffers = new ArrayList<>();
        expectedOffers.add(new OfferCommuterPass());
        expectedOffers.add(new OfferCommuterPass());

        when(offerService.getAllOfferCommuterPasses()).thenReturn(expectedOffers);

        List<OfferCommuterPass> result = offerController.getAllOfferCommuterPasses();

        assertEquals(expectedOffers, result);
    }

    @Test
    public void testGetAllOfferSeasonTickets() {
        List<OfferSeasonTicket> expectedOffers = new ArrayList<>();
        expectedOffers.add(new OfferSeasonTicket());
        expectedOffers.add(new OfferSeasonTicket());

        when(offerService.getAllOfferSeasonTickets()).thenReturn(expectedOffers);

        List<OfferSeasonTicket> result = offerController.getAllOfferSeasonTickets();

        assertEquals(expectedOffers, result);
    }
}
