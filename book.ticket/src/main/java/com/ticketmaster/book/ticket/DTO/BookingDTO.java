package com.ticketmaster.book.ticket.DTO;

import com.ticketmaster.book.ticket.entity.Ticket;

import java.util.List;

public class BookingDTO {
    private String status;
    private List<TicketDTO> tickets;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }
}
