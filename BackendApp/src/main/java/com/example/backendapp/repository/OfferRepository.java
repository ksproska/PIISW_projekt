package com.example.backendapp.repository;

import com.example.backendapp.model.offer.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository<T extends Offer> extends JpaRepository<T,Long> {}
