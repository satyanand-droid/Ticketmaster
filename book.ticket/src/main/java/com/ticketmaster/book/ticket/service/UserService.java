package com.ticketmaster.book.ticket.service;

import com.ticketmaster.book.ticket.entity.User;
import com.ticketmaster.book.ticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User getUser(Long id) {
    Optional<User> user = userRepository.findById(id);
    return user.orElse(null);
  }
}
