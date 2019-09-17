package pl.mirek.thymeleafcoursemh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.mirek.thymeleafcoursemh.repository.CarRepository;
import pl.mirek.thymeleafcoursemh.service.CarService;

@SpringBootApplication
public class ThymeleafcoursemhApplication {

    private CarService carService;

    @Autowired
    public ThymeleafcoursemhApplication(CarService carService) {
        this.carService = carService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafcoursemhApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationInitialize() {
        carService.initCarBase();
    }

}
