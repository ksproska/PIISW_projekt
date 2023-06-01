package com.example.backendapp.model.ticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SingleTicketTest {

    private SingleTicket singleTicket;

    @BeforeEach
    public void setUp() {
        singleTicket = new SingleTicket();
    }

    @Test
    public void testIsActiveForTram_NotActiveForDifferentTramId() {
        String tramId = "123";
        singleTicket.setTramId(tramId);
        Date verificationDate = Calendar.getInstance().getTime();
        singleTicket.setClipTime(verificationDate);

        assertFalse(singleTicket.isActiveForTram("456", verificationDate));
    }

    @Test
    public void testIsActiveForTram_NotActiveIfTramIdIsNull() {
        singleTicket.setTramId(null);
        Date verificationDate = Calendar.getInstance().getTime();
        singleTicket.setClipTime(verificationDate);

        assertFalse(singleTicket.isActiveForTram("123", verificationDate));
    }

    @Test
    public void testIsActive_ActiveIfClipTimeIsBeforeVerificationDateAndSameDay() {
        Date clipTime = new Date();
        clipTime.setHours(10);
        clipTime.setMinutes(0);
        singleTicket.setClipTime(clipTime);

        Date verificationDate = new Date();
        verificationDate.setHours(15);
        verificationDate.setMinutes(0);

        assertTrue(singleTicket.isActive(verificationDate));
    }

    @Test
    public void testIsActive_NotActiveIfClipTimeIsAfterVerificationDate() {
        Date clipTime = new Date();
        clipTime.setHours(16);
        clipTime.setMinutes(0);
        singleTicket.setClipTime(clipTime);

        Date verificationDate = new Date();
        verificationDate.setHours(10);
        verificationDate.setMinutes(0);

        assertFalse(singleTicket.isActive(verificationDate));
    }

    @Test
    public void testIsActive_NotActiveIfClipTimeIsOnDifferentDay() {
        Date clipTime = new Date();
        clipTime.setHours(10);
        clipTime.setMinutes(0);
        clipTime.setDate(1);
        singleTicket.setClipTime(clipTime);

        Date verificationDate = new Date();
        verificationDate.setHours(10);
        verificationDate.setMinutes(0);
        verificationDate.setDate(2);

        assertFalse(singleTicket.isActive(verificationDate));
    }

    @Test
    public void testType_ReturnsSingle() {
        assertEquals("SINGLE", singleTicket.type());
    }

    @Test
    public void testActiveTill_ReturnsNull() {
        assertNull(singleTicket.activeTill());
    }
}
