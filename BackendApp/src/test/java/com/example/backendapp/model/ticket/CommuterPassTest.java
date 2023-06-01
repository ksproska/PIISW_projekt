package com.example.backendapp.model.ticket;

import com.example.backendapp.model.common.CommuterPassDuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CommuterPassTest {

    private CommuterPass commuterPass;

    @BeforeEach
    public void setUp() {
        commuterPass = new CommuterPass();
    }

    @Test
    public void testActiveForTram_SetsClipTime() {
        Date dateOfActivation = new Date();
        commuterPass.activeForTram("123", dateOfActivation);

        assertEquals(dateOfActivation, commuterPass.getClipTime());
    }

    @Test
    public void testIsActive_NotActiveIfClipTimeIsAfterActiveTillDate() {
        Date clipTime = new Date();
        clipTime.setHours(10);
        clipTime.setMinutes(0);
        commuterPass.setClipTime(clipTime);

        Date verificationDate = new Date();
        verificationDate.setHours(15);
        verificationDate.setMinutes(0);

        commuterPass.setValidityLengthInMinutes(CommuterPassDuration.HOUR);

        assertFalse(commuterPass.isActive(verificationDate));
    }

    @Test
    public void testType_ReturnsValidityLengthInMinutesName() {
        commuterPass.setValidityLengthInMinutes(CommuterPassDuration.HALF_HOUR);

        assertEquals("HALF_HOUR", commuterPass.type());
    }

    @Test
    public void testActiveTill_ReturnsNullIfClipTimeIsNull() {
        assertNull(commuterPass.activeTill());
    }

    @Test
    public void testActiveTill_ReturnsCorrectDateIfClipTimeIsSet() {
        Date clipTime = new Date();
        commuterPass.setClipTime(clipTime);
        commuterPass.setValidityLengthInMinutes(CommuterPassDuration.HOUR);

        Calendar expectedDate = Calendar.getInstance();
        expectedDate.setTime(clipTime);
        expectedDate.add(Calendar.MINUTE, 60);

        assertEquals(expectedDate.getTime(), commuterPass.activeTill());
    }
}
