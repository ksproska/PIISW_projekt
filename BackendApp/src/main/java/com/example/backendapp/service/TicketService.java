package com.example.backendapp.service;

import com.example.backendapp.controller.request.CreateTicketRequest;
import com.example.backendapp.model.common.TicketStatus;
import com.example.backendapp.model.offer.Offer;
import com.example.backendapp.model.offer.OfferCommuterPass;
import com.example.backendapp.model.offer.OfferSeasonTicket;
import com.example.backendapp.model.offer.OfferSingleTicket;
import com.example.backendapp.model.ticket.*;
import com.example.backendapp.model.user.Passenger;
import com.example.backendapp.repository.OfferRepository;
import com.example.backendapp.repository.TicketRepository;
import com.example.backendapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.javatuples.Pair;

import java.util.*;

@Service
@AllArgsConstructor
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<Ticket> getTicketById(long id) { return ticketRepository.findById(id); }

    public String isActiveForTram(long ticketId, String tramId) {
        var ticket = ticketRepository.findById(ticketId);
        if (ticket.isEmpty()) return TicketStatus.NOT_FOUND.getStatus();
        var timeNow = Calendar.getInstance().getTime();
        if (ticket.get().getClipTime() == null) {
            return TicketStatus.NOT_CLIPPED.getStatus();
        }
        if (ticket.get().isActiveForTram(tramId, timeNow)) {
            return TicketStatus.VALID.getStatus();
        }
        return TicketStatus.INVALID.getStatus();
    }

    public List<TicketInfo> getTicketInfo(Long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        List<Ticket> tickets = ticketRepository.findAllByOwnerIdOrderByIdDesc(user.getId());
        return tickets.stream().map(t -> new TicketInfo(t)).toList();
    }

    public void saveSingleTicket(CreateTicketRequest request) {
        Pair<Passenger, OfferSingleTicket> passengerWithOffer = getPassengerAndOffer(request.userId(), request.offerId());
        var user = passengerWithOffer.getValue0();
        var offer = passengerWithOffer.getValue1();

        var ticket = new SingleTicket();
        ticket.setPrice(offer.getPrice());
        ticket.setConcession(offer.getConcession());
        ticket.setOwner(user);

        ticketRepository.save(ticket);
    }

    public void saveSeasonTicket(CreateTicketRequest request) {
        Pair<Passenger, OfferSeasonTicket> passengerWithOffer = getPassengerAndOffer(request.userId(), request.offerId());
        var user = passengerWithOffer.getValue0();
        var offer = passengerWithOffer.getValue1();

        var ticket = new SeasonTicket();
        ticket.setPrice(offer.getPrice());
        ticket.setConcession(offer.getConcession());
        ticket.setOwner(user);
        ticket.setClipTime(Calendar.getInstance().getTime());
        ticket.setValidityLengthInDays(offer.getValidityLengthInDays());

        ticketRepository.save(ticket);
    }

    public void saveCommuterPass(CreateTicketRequest request) {
        Pair<Passenger, OfferCommuterPass> passengerWithOffer = getPassengerAndOffer(request.userId(), request.offerId());
        var user = passengerWithOffer.getValue0();
        var offer = passengerWithOffer.getValue1();

        var ticket = new CommuterPass();
        ticket.setPrice(offer.getPrice());
        ticket.setConcession(offer.getConcession());
        ticket.setOwner(user);
        ticket.setValidityLengthInMinutes(offer.getValidityLengthInMinutes());

        ticketRepository.save(ticket);
    }

    public boolean activateTicket(Long ticketId, String tramId) throws NoSuchElementException, IllegalStateException {
        var ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new NoSuchElementException("Ticket not found"));
        Date timeNow = Calendar.getInstance().getTime();
        if (!ticket.isActiveForTram(tramId, timeNow) && ticket.getClipTime() == null) {
            ticket.activeForTram(tramId, timeNow);
            ticketRepository.save(ticket);
            return true;
        }
        throw new IllegalStateException("Couldn't activate this ticket");
    }

    private <T extends Offer> Pair<Passenger, T> getPassengerAndOffer(Long userId, Long offerId) throws NoSuchElementException
    {
        var user = (Passenger) userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        var offer = (T) offerRepository.findById(offerId).orElseThrow();
        return new Pair<Passenger, T>(user, offer);
    }
}
