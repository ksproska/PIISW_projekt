package com.example.backendapp.model.offer;

import com.example.backendapp.model.common.SeasonTicketDuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfferSeasonTicketTest {

    private OfferSeasonTicket offerSeasonTicket;

    @BeforeEach
    public void setUp() {
        offerSeasonTicket = new OfferSeasonTicket();
    }

    @Test
    public void testGetValidityLengthInDays() {
        offerSeasonTicket.setValidityLengthInDays(SeasonTicketDuration.WEEK);

        assertEquals(SeasonTicketDuration.WEEK, offerSeasonTicket.getValidityLengthInDays());
    }

    @Test
    public void testSetValidityLengthInDays() {
        offerSeasonTicket.setValidityLengthInDays(SeasonTicketDuration.SEMESTER);

        assertEquals(SeasonTicketDuration.SEMESTER, offerSeasonTicket.getValidityLengthInDays());
    }
}
