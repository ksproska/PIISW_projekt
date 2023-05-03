package com.example.backendapp.service;

import com.example.backendapp.model.offer.OfferCommuterPass;
import com.example.backendapp.model.offer.OfferSeasonTicket;
import com.example.backendapp.model.offer.OfferSingleTicket;
import com.example.backendapp.repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class OfferService {
    @Autowired
    OfferRepository repository;

    public List<OfferSingleTicket> getAllOfferSingleTickets() {
        return repository.findAllOfferSingleTickets();
    }

    public List<OfferSeasonTicket> getAllOfferSeasonTickets() {
        return repository.findAllOfferSeasonTickets();
    }

    public List<OfferCommuterPass> getAllOfferCommuterPasses() {
        return repository.findAllOfferCommuterPasses();
    }
}
