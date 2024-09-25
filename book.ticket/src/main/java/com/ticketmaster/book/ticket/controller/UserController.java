package com.ticketmaster.book.ticket.controller;

import com.ticketmaster.book.ticket.DTO.UserDTO;
import com.ticketmaster.book.ticket.entity.User;
import com.ticketmaster.book.ticket.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired UserService userService;

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @GetMapping("/{id}")
  public UserDTO getUserById(@PathVariable Long id) {
    return userService.getUser(id);
  }
}
