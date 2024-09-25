package com.ticketmaster.book.ticket.controller;

import com.ticketmaster.book.ticket.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket/reserve")
public class BookingController {

  @Autowired private BookingService bookingService;

  @PostMapping
  public Long reserveTicket(@RequestParam Long id, @RequestBody List<Long> tickets) {
    return bookingService.reserveTicket(id, tickets);
  }
}
