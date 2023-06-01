package com.example.backendapp.controller.api;

import com.example.backendapp.model.offer.OfferCommuterPass;
import com.example.backendapp.model.offer.OfferSeasonTicket;
import com.example.backendapp.model.offer.OfferSingleTicket;
import com.example.backendapp.service.OfferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/public")
@Tag(name = "Public ticket offers", description = "Public API. Allows any client to download information about available offers")
public class OfferController {
    @Autowired
    OfferService service;

    @Operation(summary = "Get list of single tickets offer")
    @GetMapping("/offers/singletickets")
    public List<OfferSingleTicket> getOfferSingleTickets() {
        return service.getAllOfferSingleTickets();
    }

    @Operation(summary = "Get list of commuterpasses tickets offer")
    @GetMapping("/offers/commuterpasses")
    public List<OfferCommuterPass> getAllOfferCommuterPasses() {
        return service.getAllOfferCommuterPasses();
    }

    @Operation(summary = "Get list of seasontickets tickets offer")
    @GetMapping("/offers/seasontickets")
    public List<OfferSeasonTicket> getAllOfferSeasonTickets() {
        return service.getAllOfferSeasonTickets();
    }
}
