package com.example.backendapp.controller.request;

import jakarta.validation.constraints.NotBlank;

public record CreateTicketRequest(@NotBlank Long userId, @NotBlank Long offerId) {}
