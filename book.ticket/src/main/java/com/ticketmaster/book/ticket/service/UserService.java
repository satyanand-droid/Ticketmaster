package com.ticketmaster.book.ticket.service;

import com.ticketmaster.book.ticket.DTO.UserDTO;
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

  public UserDTO getUser(Long id) {
    UserDTO userDTO= new UserDTO();
    Optional<User> user = userRepository.findById(id);
    if(user.isPresent()){
          userDTO.setEmail(user.get().getEmail());
          userDTO.setUsername(user.get().getUsername());
    }
    return userDTO;
  }
}
