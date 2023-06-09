package com.example.backendapp.repository;

import com.example.backendapp.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByOwnerIdOrderByIdDesc(Long userId);
}
