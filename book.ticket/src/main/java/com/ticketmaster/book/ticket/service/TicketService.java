package com.ticketmaster.book.ticket.service;

import com.ticketmaster.book.ticket.entity.Ticket;
import com.ticketmaster.book.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

  @Autowired TicketRepository ticketRepository;

  public Ticket createTicket(Ticket ticket) {
    return ticketRepository.save(ticket);
  }
}
