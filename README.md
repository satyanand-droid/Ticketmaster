# Ticketmaster

Ticket Booking System

This project demonstrates a simple **ticket reservation and booking system** using **Spring Boot**, **Redis** for distributed locking, and **Optimistic Concurrency Control (OCC)** for handling concurrent updates.

## Key Features

- **Reserve Ticket API**: Allows users to reserve tickets while ensuring that no other user can reserve the same ticket at the same time by leveraging Redis as a distributed lock.
- **Confirm Ticket API**: Confirms the reserved tickets and marks them as booked, ensuring no two users can book the same ticket via OCC.
- **Redis Distributed Locking**: Prevents race conditions where multiple users try to book the same ticket by implementing Redis-based locks.
- **Optimistic Concurrency Control (OCC)**: Ensures that concurrent modifications to the same ticket are handled properly using versioning, thus avoiding booking conflicts.
