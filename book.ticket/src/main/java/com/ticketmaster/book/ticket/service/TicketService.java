package com.ticketmaster.book.ticket.service;

import com.ticketmaster.book.ticket.DTO.TicketDTO;
import com.ticketmaster.book.ticket.entity.Ticket;
import com.ticketmaster.book.ticket.repository.TicketRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

  @Autowired TicketRepository ticketRepository;

  public Ticket createTicket(Ticket ticket) {
    return ticketRepository.save(ticket);
  }

  public TicketDTO getTicket(Long id) {
    TicketDTO ticketDTO = new TicketDTO();
    Optional<Ticket> ticket = ticketRepository.findById(id);
    if (ticket.isPresent()) {
      ticketDTO.setTicketStatus(ticket.get().getStatus());
      ticketDTO.setVersion(ticket.get().getVersion());
      ticketDTO.setEvent(ticket.get().getEvent());
      ticketDTO.setSeat(ticket.get().getSeatNo());
    }
    return ticketDTO;
  }
}
