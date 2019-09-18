package pl.mirek.thymeleafcoursemh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mirek.thymeleafcoursemh.dto.CarDto;
import pl.mirek.thymeleafcoursemh.service.CarService;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    /*
     *
     * !!! server.port=8084 !!!
     *
     * */
    @GetMapping(value = "/")
    public String home() {
        return "redirect:/cars";
    }

    @GetMapping(value = "/car")
    public String get(Model model) {
        model.addAttribute("name", "Mirek");
        model.addAttribute("car", carService.getCarById(2));
        return "car";
    }

    @GetMapping(value = "/cars")
    public String getCars(Model model) {
        model.addAttribute("name", "Mirek");
        model.addAttribute("cars", carService.getCarsForDisplay());
        model.addAttribute("newCar", new Car());
        return "cars";
    }

    @PostMapping(value = "/add-car")
    public String addCar(@ModelAttribute Car newCar) {
        if (!newCar.getMark().equals("") && !newCar.getModel().equals("")) {
            carService.addCar(newCar);
        }
        return "redirect:/cars";
    }

    @GetMapping(value = "/delete-car")
    public String deleteCar(Model model) {
        model.addAttribute("name", "Mirek");
        model.addAttribute("cars", carService.getCarsForDisplay());
        model.addAttribute("oldCar", new CarDto());
        return "deletecar";
    }

    @PostMapping(value = "/delete-car")
    public String doDeleteCar(@ModelAttribute CarDto carDto) {
        carService.deleteCar(carDto);
        return "redirect:cars";
    }

    @GetMapping(value = "/modify-car")
    public String modifyCar(Model model) {
        model.addAttribute("name", "Mirek");
        model.addAttribute("cars", carService.getCarsForDisplay());
        model.addAttribute("oldCar", new CarDto());
        return "modifycar";
    }

    @PostMapping(value = "/modify-car")
    public String doModifyCar(@ModelAttribute CarDto carDto) {
        carService.modifyCar(carDto);
        return "redirect:cars";
    }
}
