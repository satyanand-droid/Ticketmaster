package com.ticketmaster.book.ticket.controller;

import com.ticketmaster.book.ticket.service.BookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class BookingController {

  @Autowired private BookingService bookingService;

  @PostMapping("/reserve")
  public Long reserveTicket(@RequestParam Long id, @RequestBody List<Long> tickets) {
    return bookingService.reserveTicket(id, tickets);
  }

  @PostMapping("/confirm/{bookingId}")
  public String confirmTicket(@PathVariable Long bookingId) {
    bookingService.confirmTicket(bookingId);
    return "booking confirmed successfully";
  }
}
