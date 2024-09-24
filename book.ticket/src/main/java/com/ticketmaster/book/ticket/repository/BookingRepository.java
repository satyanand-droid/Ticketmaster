package com.ticketmaster.book.ticket.repository;

import com.ticketmaster.book.ticket.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {}
