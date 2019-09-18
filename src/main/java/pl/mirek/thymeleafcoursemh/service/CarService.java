package pl.mirek.thymeleafcoursemh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mirek.thymeleafcoursemh.Car;
import pl.mirek.thymeleafcoursemh.dto.CarDto;
import pl.mirek.thymeleafcoursemh.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public void addCar(Car car) {
        this.repository.getCars().add(car);
    }

    public void initCarBase() {
        addCar(new Car("BMW", "i8"));
        addCar(new Car("Fiat", "126p"));
        addCar(new Car("Polonez", "Caro"));
        addCar(new Car("Hyundai", "i30"));
    }

    public Car getCarById(int id) {
        return this.repository.getCars().get(id);
    }

    public List<CarDto> getCarsForDisplay() {
        int carsTotal = this.repository.getCars().size();
        List<CarDto> output = new ArrayList<>();
        for (int i = 0; i < carsTotal; i++) {
            output.add(new CarDto(i,
                    this.repository.getCars().get(i).getMark(),
                    this.repository.getCars().get(i).getModel()
            ));
        }
        return output;
    }

    public void deleteCar(CarDto carDto) {
        repository.getCars().remove(carDto.id);
    }

    public void modifyCar(CarDto carDto) {
        Car car = this.getCarById(carDto.id);
        if (!carDto.mark.equals("")) {
            car.setMark(carDto.mark);
        }

        if (!carDto.model.equals("")) {
            car.setModel(carDto.model);
        }
    }
}
