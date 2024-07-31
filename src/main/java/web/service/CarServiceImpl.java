package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    Car car1 = new Car("Lada", 2110, "white");
    Car car2 = new Car("GAZ", 3110, "black");
    Car car3 = new Car("Ford", 200, "white");
    Car car4 = new Car("Land Cruiser", 200, "yellow");
    Car car5 = new Car("Ferrari", 430, "red");
    List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> showCars(int count) {
        return getCars().stream().limit(count).toList();
    }

    public List<Car> getCars() {
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        return cars;
    }
}
