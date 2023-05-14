package com.example.backendapp.service;

import com.example.backendapp.controller.CreateTicketRequest;
import com.example.backendapp.controller.CreateSingleTicketRequest;
import com.example.backendapp.model.offer.OfferCommuterPass;
import com.example.backendapp.model.offer.OfferSeasonTicket;
import com.example.backendapp.model.offer.OfferSingleTicket;
import com.example.backendapp.model.ticket.CommuterPass;
import com.example.backendapp.model.ticket.SeasonTicket;
import com.example.backendapp.model.ticket.SingleTicket;
import com.example.backendapp.model.ticket.Ticket;
import com.example.backendapp.model.user.Passenger;
import com.example.backendapp.repository.OfferRepository;
import com.example.backendapp.repository.TicketRepository;
import com.example.backendapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public boolean verifyTicket(long id, String tramId) throws NoSuchElementException
    {
        // TODO validation
        var ticket = ticketRepository.findById(id);
        if (ticket.isEmpty()) throw new NoSuchElementException("Ticket with id '" + id + "' not found");
        return ticket.get().verifyTicket(tramId, Calendar.getInstance().getTime());
    }

    public List<TicketInfo> getTicketInfo(Long userId) {
        List<Ticket> tickets = ticketRepository.findAllByOwnerId(userId);
        List<TicketInfo> ticketInfos = tickets.stream().map(t -> new TicketInfo(t)).toList();
        return ticketInfos;
    }

    public void saveSingleTicket(CreateSingleTicketRequest request) {
        Passenger user = (Passenger) userRepository.findById(request.userId()).orElse(null);
        OfferSingleTicket offer = (OfferSingleTicket) offerRepository.findById(request.offerId()).orElse(null);

        var ticket = new SingleTicket();
        ticket.setPrice(offer.getPrice());
        ticket.setConcession(offer.getConcession());
        ticket.setOwner(user);
        ticket.setClipTime(Calendar.getInstance().getTime());
        ticket.setTramId(request.tramId());

        ticketRepository.save(ticket);
    }

    public void saveSeasonTicket(CreateTicketRequest request) {
        Passenger user = (Passenger) userRepository.findById(request.userId()).orElse(null);
        OfferSeasonTicket offer = (OfferSeasonTicket) offerRepository.findById(request.offerId()).orElse(null);

        var ticket = new SeasonTicket();
        ticket.setPrice(offer.getPrice());
        ticket.setConcession(offer.getConcession());
        ticket.setOwner(user);
        ticket.setClipTime(Calendar.getInstance().getTime());
        ticket.setValidityLengthInDays(offer.getValidityLengthInDays());

        ticketRepository.save(ticket);
    }

    public void saveCommuterPass(CreateTicketRequest request) {
        Passenger user = (Passenger) userRepository.findById(request.userId()).orElse(null);
        OfferCommuterPass offer = (OfferCommuterPass) offerRepository.findById(request.offerId()).orElse(null);

        var ticket = new CommuterPass();
        ticket.setPrice(offer.getPrice());
        ticket.setConcession(offer.getConcession());
        ticket.setOwner(user);
        ticket.setClipTime(Calendar.getInstance().getTime());
        ticket.setValidityLengthInMinutes(offer.getValidityLengthInMinutes());

        ticketRepository.save(ticket);
    }
}
