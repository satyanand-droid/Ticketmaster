package com.ticketmaster.book.ticket.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // For auto-incrementing primary key
    private Long id;

    @Column(nullable = false, unique = true)  // Username should be unique
    private String username;

    @Column(nullable = false, unique = true)  // Email should be unique
    private String email;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  List<Booking> booking;

    public User() {
    }

    public User(String username, String email, List<Booking> booking) {
        this.username = username;
        this.email = email;
        this.booking=booking;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}