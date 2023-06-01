package com.example.backendapp.controller.api;

import com.example.backendapp.controller.request.CreateTicketRequest;
import com.example.backendapp.controller.response.VerificationMessage;
import com.example.backendapp.service.TicketInfo;
import com.example.backendapp.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@SecurityRequirement(name = "Barer Authentication")
@Tag(name = "Ticket controller", description = "Contains operations available to the logged-in user and the ticket controller")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Operation(summary = "Verify ticket by ticketId and tramId")
    @GetMapping("/ticket-collector/tickets/{ticketId}/verify/{tramId}")
    public VerificationMessage verifyTicket(@PathVariable long ticketId, @PathVariable String tramId) {
        return new VerificationMessage(ticketService.isActiveForTram(ticketId, tramId));
    }

    @Operation(summary = "Activate ticket as ticket collector by ticketId and tramId")
    @PutMapping("/ticket-collector/tickets/{ticketId}/activate/{tramId}")
    public void activateTicket(@PathVariable long ticketId, @PathVariable String tramId) {
        ticketService.activateTicket(ticketId, tramId);
    }

    @Operation(summary = "Activate ticket as user by ticketId and tramId")
    @PutMapping("/passenger/tickets/{ticketId}/activate/{tramId}")
    public void activateTicketAsUser(@PathVariable long ticketId, @PathVariable String tramId) {
        ticketService.activateTicket(ticketId, tramId);
    }

    @Operation(summary = "Returns list of tickets attached to user")
    @GetMapping("/passenger/tickets/{userId}")
    List<TicketInfo> getTicketInfoForUserId(@PathVariable Long userId) {
        return ticketService.getTicketInfo(userId);
    }

    @Operation(summary = "Buy singleticket (In this version we assume that payment has already been made)")
    @PutMapping("/passenger/tickets/buy/singleticket")
    public void putSingleTicketFromOfferForUserId(@RequestBody CreateTicketRequest request) {
        ticketService.saveSingleTicket(request);
    }

    @Operation(summary = "Buy seasonticket (In this version we assume that payment has already been made)")
    @PutMapping("/passenger/tickets/buy/seasonticket")
    public void putSeasonTicketFromOfferForUserId(@RequestBody CreateTicketRequest request) {
        ticketService.saveSeasonTicket(request);
    }

    @Operation(summary = "Buy commuterpass (In this version we assume that payment has already been made)")
    @PutMapping("/passenger/tickets/buy/commuterpass")
    public void putCommuterPassFromOfferForUserId(@RequestBody CreateTicketRequest request) {
        ticketService.saveCommuterPass(request);
    }
}
