package com.example.backendapp.model.common;

public enum TicketStatus
{
    VALID("valid"),
    INVALID("NOT valid"),
    NOT_CLIPPED("NOT clipped"),
    NOT_FOUND("NOT found");

    private String status;

    private TicketStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
}
