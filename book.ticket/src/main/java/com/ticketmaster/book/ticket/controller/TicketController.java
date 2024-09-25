package com.ticketmaster.book.ticket.controller;

import com.ticketmaster.book.ticket.entity.Ticket;
import com.ticketmaster.book.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

  @Autowired TicketService ticketService;

  @PostMapping
  public Ticket createTicket(@RequestBody Ticket ticket) {
    return ticketService.createTicket(ticket);
  }

  @GetMapping("/{id}")
  public Ticket getTicket(@PathVariable Long id){
    return ticketService.getTicket(id);
  }
}
