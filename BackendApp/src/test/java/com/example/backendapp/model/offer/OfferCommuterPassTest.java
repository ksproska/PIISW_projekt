package com.example.backendapp.model.offer;

import com.example.backendapp.model.common.CommuterPassDuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfferCommuterPassTest {

    private OfferCommuterPass offerCommuterPass;

    @BeforeEach
    public void setUp() {
        offerCommuterPass = new OfferCommuterPass();
    }

    @Test
    public void testGetValidityLengthInMinutes() {
        offerCommuterPass.setValidityLengthInMinutes(CommuterPassDuration.HALF_HOUR);

        assertEquals(CommuterPassDuration.HALF_HOUR, offerCommuterPass.getValidityLengthInMinutes());
    }

    @Test
    public void testSetValidityLengthInMinutes() {
        offerCommuterPass.setValidityLengthInMinutes(CommuterPassDuration.HOUR);

        assertEquals(CommuterPassDuration.HOUR, offerCommuterPass.getValidityLengthInMinutes());
    }
}
