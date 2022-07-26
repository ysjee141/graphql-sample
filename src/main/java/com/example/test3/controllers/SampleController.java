package com.example.test3.controllers;


import com.example.test3.models.User;
import com.example.test3.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class SampleController {

  private final UserService service;

  public SampleController(UserService service) {
    this.service = service;
  }

  @QueryMapping
  public User getUser(@Argument int id) {
    return service.get(id);
  }

  @QueryMapping
  public Flux<User> getUsers() {
    return service.get();
  }


}
