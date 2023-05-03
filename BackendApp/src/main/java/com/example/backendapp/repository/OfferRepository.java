package com.example.backendapp.repository;

import com.example.backendapp.model.offer.Offer;
import com.example.backendapp.model.offer.OfferCommuterPass;
import com.example.backendapp.model.offer.OfferSeasonTicket;
import com.example.backendapp.model.offer.OfferSingleTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository<T extends Offer> extends JpaRepository<T, Long> {
    @Query("from OfferSingleTicket")
    List<OfferSingleTicket> findAllOfferSingleTickets();

    @Query("from OfferSeasonTicket")
    List<OfferSeasonTicket> findAllOfferSeasonTickets();

    @Query("from OfferCommuterPass")
    List<OfferCommuterPass> findAllOfferCommuterPasses();
}
