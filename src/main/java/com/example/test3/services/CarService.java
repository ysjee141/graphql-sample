package com.example.test3.services;

import com.example.test3.models.Car;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;

@Service
public class CarService implements BaseService<Car> {

  private final Map<Integer, Car> dataMap = new ConcurrentHashMap<>();

  @PostConstruct
  private void init() {
    Car u = new Car();
    u.setId(1);
    u.setName("스포티지");
    u.setPrice(3000);

    Car u1 = new Car();
    u1.setId(2);
    u1.setName("벤츠");
    u1.setPrice(10000);

    dataMap.put(1, u);
    dataMap.put(2, u1);
  }

  @Override
  public Car get(int id) {
    return dataMap.get(id);
  }

  @Override
  public Flux<Car> get() {
    return Flux.fromIterable(dataMap.values());
  }

  @Override
  public void set(Car data) {
    Optional<Integer> id = dataMap.keySet().stream().max(Comparator.comparingInt(Integer::intValue));

    if(id.isEmpty()) {
      id = Optional.of(1);
    } else {
      id = Optional.of(id.get() + 1);
    }

    data.setId(id.orElse(1));
    dataMap.put(data.getId(), data);
  }

  @Override
  public void remove(int id) {
    dataMap.remove(id);
  }
}
