package com.example.backendapp.model.ticket;

import com.example.backendapp.model.common.SeasonTicketDuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SeasonTicketTest {

    private SeasonTicket seasonTicket;

    @BeforeEach
    public void setUp() {
        seasonTicket = new SeasonTicket();
    }

    @Test
    public void testActiveForTram_SetsClipTime() {
        Date dateOfActivation = new Date();
        seasonTicket.activeForTram("123", dateOfActivation);

        assertEquals(dateOfActivation, seasonTicket.getClipTime());
    }

    @Test
    public void testType_ReturnsValidityLengthInDaysName() {
        seasonTicket.setValidityLengthInDays(SeasonTicketDuration.MONTH);

        assertEquals("MONTH", seasonTicket.type());
    }

    @Test
    public void testActiveTill_ReturnsNullIfClipTimeIsNull() {
        assertNull(seasonTicket.activeTill());
    }

    @Test
    public void testActiveTill_ReturnsCorrectDateIfClipTimeIsSet() {
        Date clipTime = new Date();
        seasonTicket.setClipTime(clipTime);
        seasonTicket.setValidityLengthInDays(SeasonTicketDuration.WEEK);

        Calendar expectedDate = Calendar.getInstance();
        expectedDate.setTime(clipTime);
        expectedDate.add(Calendar.DATE, 7);

        assertEquals(expectedDate.getTime(), seasonTicket.activeTill());
    }
}
