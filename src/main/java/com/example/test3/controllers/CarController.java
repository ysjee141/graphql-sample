package com.example.test3.controllers;

import com.example.test3.models.Car;
import com.example.test3.services.CarService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class CarController {

  private final CarService service;

  public CarController(CarService service) {
    this.service = service;
  }

  @QueryMapping
  public Flux<Car> getCars () {
    return service.get();
  }

  @MutationMapping
  public void saveCar(@Argument String name, @Argument int price) {
    Car c = new Car();
    c.setName(name);
    c.setPrice(price);
    service.set(c);
  }

}
