package com.example.backendapp.model.ticket;

public enum CommuterPassDuration {

    //DURATION IN MINUTES
    QUARTER(15),
    HALF_HOUR(30),
    HOUR(60),
    DAY(60 * 24);

    private final int value;
    CommuterPassDuration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
