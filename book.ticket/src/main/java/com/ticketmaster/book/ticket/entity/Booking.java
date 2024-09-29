package com.ticketmaster.book.ticket.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Ticket> tickets = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private BookingStatus bookingStatus;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  public Booking() {}

  public Booking(Long id, List<Ticket> tickets, BookingStatus bookingStatus, User user) {
    this.id = id;
    this.tickets = tickets;
    this.bookingStatus = bookingStatus;
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }

  public BookingStatus getBookingStatus() {
    return bookingStatus;
  }

  public void setBookingStatus(BookingStatus bookingStatus) {
    this.bookingStatus = bookingStatus;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void addTicket(Ticket ticket) {
    tickets.add(ticket);
    ticket.setBooking(this);
  }
}
