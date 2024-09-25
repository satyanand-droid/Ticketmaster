package com.ticketmaster.book.ticket.repository;

import com.ticketmaster.book.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
