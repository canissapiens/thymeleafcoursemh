package pl.mirek.thymeleafcoursemh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @GetMapping(value = "/car")
    public String get(Model model) {
        model.addAttribute("name", "Mirek");
        Car car = new Car("Fiat", "Panda");
        model.addAttribute("car", car);
        return "car";
    }
}
