package com.ticketmaster.book.ticket.DTO;

import com.ticketmaster.book.ticket.entity.TicketStatus;

public class TicketDTO {

    private String seat;
    private String event;
    private long version;
    private TicketStatus ticketStatus;

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
