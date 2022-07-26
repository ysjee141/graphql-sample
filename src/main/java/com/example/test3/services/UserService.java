package com.example.test3.services;

import com.example.test3.models.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;

@Service
public class UserService implements BaseService<User> {

  private final Map<Integer, User> dataMap = new ConcurrentHashMap<>();

  @PostConstruct
  private void init() {
    User u = new User();
    u.setId(1);
    u.setName("A");
    u.setAge(20);

    User u1 = new User();
    u1.setId(2);
    u1.setName("B");
    u1.setAge(25);

    dataMap.put(1, u);
    dataMap.put(2, u1);
  }

  @Override
  public User get(int id) {
    return dataMap.get(id);
  }

  @Override
  public Flux<User> get() {
    return Flux.fromIterable(dataMap.values());
  }

  @Override
  public void set(User data) {
    dataMap.put(data.getId(), data);
  }

  @Override
  public void remove(int id) {
    dataMap.remove(id);
  }
}
