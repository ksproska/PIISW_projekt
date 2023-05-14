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

    @GetMapping("/{id}/verify/{tramId}")
    public ResponseEntity<Object> VerifyTicket(@PathVariable long id, @PathVariable String tramId)
    {
        try
        {
            var result = ticketService.verifyTicket(id, tramId);
            return ResponseEntity.ok(result);
        }
        catch (NoSuchElementException e)
        {
            // TODO log message
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ticketinfo/{userId}")
    List<TicketInfo> getTicketInfoForUserId(@PathVariable Long userId) {
        return ticketService.getTicketInfo(userId);
    }

    @PutMapping("/offer/singleticket")
    public void putSingleTicketFromOfferForUserId(@RequestBody CreateSingleTicketRequest request) {
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
