package com.example.test3.services;

import reactor.core.publisher.Flux;

public interface BaseService<T> {

  T get(int id);
  Flux<T> get();

  void set(T data);
  void remove(int id);

}
