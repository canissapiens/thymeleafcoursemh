package pl.mirek.thymeleafcoursemh.repository;

import org.springframework.stereotype.Repository;
import pl.mirek.thymeleafcoursemh.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    private List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

}
