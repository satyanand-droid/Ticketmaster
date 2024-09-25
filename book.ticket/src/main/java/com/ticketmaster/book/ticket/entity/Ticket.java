package com.ticketmaster.book.ticket.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_no", nullable = false)
    private String seatNo;

    @Enumerated(EnumType.STRING)
    @Column(name ="status", nullable = false)
    private TicketStatus status;

    @Column(name="event", nullable = false)
    private String event;

    @Column(name="price", nullable = false)
    private Double price;

  @ManyToOne
  @JoinColumn(name = "booking_id", nullable = true)
  private Booking booking;

  @Version
  private Long version;

    public Ticket() {
    }

    public Ticket(Long id, String seatNo, TicketStatus status, String event, Double price, Booking booking) {
        this.id = id;
        this.seatNo = seatNo;
        this.status = status;
        this.event = event;
        this.price = price;
        this.booking = booking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
