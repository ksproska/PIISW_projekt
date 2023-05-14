package com.example.backendapp.controller;

public record CreateSingleTicketRequest(Long userId, Long offerId, String tramId) {}
