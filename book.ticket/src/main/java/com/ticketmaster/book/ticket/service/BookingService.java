package com.ticketmaster.book.ticket.service;

import com.ticketmaster.book.ticket.entity.*;
import com.ticketmaster.book.ticket.repository.BookingRepository;
import com.ticketmaster.book.ticket.repository.TicketRepository;
import com.ticketmaster.book.ticket.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BookingService {
  private static final int LOCK_TIME = 600;

  @Autowired private UserRepository userRepository;

  @Autowired private ValueOperations<String, String> valueOperations;

  @Autowired private BookingRepository bookingRepository;

  @Autowired private TicketRepository ticketRepository;

  public Long reserveTicket(Long userId, List<Long> ticketIds) {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("no user found"));
    List<Ticket> tickets = new ArrayList<>();
    for (Long ticketId : ticketIds) {
      tickets.add(
          ticketRepository
              .findById(ticketId)
              .orElseThrow(() -> new IllegalArgumentException("no ticket found")));
      String lockKey = "ticket" + ticketId;
      String lockValue = "user" + userId;
      Boolean lock = valueOperations.setIfAbsent(lockKey, lockValue, LOCK_TIME, TimeUnit.SECONDS);
      if (lock != Boolean.TRUE) {
        throw new IllegalStateException("one of the selected ticket is booked by another user");
      }
    }
    Booking booking = new Booking();
    booking.setBookingStatus(BookingStatus.IN_PROGRESS);
    booking.setUser(user);
    booking.setTickets(tickets);
    booking = bookingRepository.save(booking);

    return booking.getId();
  }

  @Transactional
  public void confirmTicket(Long bookingId) {
    // Assuming payment is successful
    Booking booking =
        bookingRepository
            .findById(bookingId)
            .orElseThrow(() -> new IllegalArgumentException("no booking found"));
    List<Ticket> tickets = booking.getTickets();
    for (Ticket ticket : tickets) {
        String status = String.valueOf(ticket.getStatus());
        if(status.equalsIgnoreCase("booked")){
        throw new IllegalStateException("ticket is already booked");
      }
      ticket.setStatus(TicketStatus.BOOKED);
      ticket.setBooking(booking);
      ticketRepository.save(ticket);
    }
    booking.setBookingStatus(BookingStatus.SUCCESSFUL);
    bookingRepository.save(booking);
  }
}
