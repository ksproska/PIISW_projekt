package com.example.backendapp.model.ticket;

public enum SeasonTicketDuration {

    //DURATION IN DAYS
    WEEK(7),
    MONTH(31),
    SEMESTER(182),
    YEAR(365);

    private final int value;

    SeasonTicketDuration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
