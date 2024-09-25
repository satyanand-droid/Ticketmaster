package com.ticketmaster.book.ticket.service;

import com.ticketmaster.book.ticket.entity.Booking;
import com.ticketmaster.book.ticket.entity.BookingStatus;
import com.ticketmaster.book.ticket.entity.User;
import com.ticketmaster.book.ticket.repository.BookingRepository;
import com.ticketmaster.book.ticket.repository.TicketRepository;
import com.ticketmaster.book.ticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

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

    for (Long ticketId : ticketIds) {
      ticketRepository.findById(ticketId).orElseThrow(()->new IllegalArgumentException("no ticket found"));
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
    booking = bookingRepository.save(booking);

    return booking.getId();
  }
}
