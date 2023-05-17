package com.example.backendapp.controller;

import com.example.backendapp.service.TicketInfo;
import com.example.backendapp.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/{ticketId}/verify/{tramId}")
    public VerificationMessage verifyTicket(@PathVariable long ticketId, @PathVariable String tramId) {
        return new VerificationMessage(ticketService.isActiveForTram(ticketId, tramId));
    }
    @PutMapping("/{ticketId}/activate/{tramId}")
    public void activateTicket(@PathVariable long ticketId, @PathVariable String tramId) {
        var wasActivated = ticketService.activateTicket(ticketId, tramId);
        if (!wasActivated) {
            throw new IllegalStateException("Couldn't activate this ticket");
        }
    }

    @GetMapping("/ticketinfo/{userId}")
    List<TicketInfo> getTicketInfoForUserId(@PathVariable Long userId) {
        return ticketService.getTicketInfo(userId);
    }

    @PutMapping("/offer/singleticket")
    public void putSingleTicketFromOfferForUserId(@RequestBody CreateTicketRequest request) {
        ticketService.saveSingleTicket(request);
    }
    @PutMapping("/offer/seasonticket")
    public void putSeasonTicketFromOfferForUserId(@RequestBody CreateTicketRequest request) {
        ticketService.saveSeasonTicket(request);
    }
    @PutMapping("/offer/commuterpass")
    public void putCommuterPassFromOfferForUserId(@RequestBody CreateTicketRequest request) {
        ticketService.saveCommuterPass(request);
    }
}
