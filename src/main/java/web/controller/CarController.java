package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    public CarService carService;


    @GetMapping("/cars")
    public String showCarsList(@RequestParam(defaultValue = "5")  int count, Model model) {
        if (count >= 5) {
            model.addAttribute("cars", carService.showCars(5));
        } else {
            model.addAttribute("cars", carService.showCars(count));
        }

        return "cars";
    }
}
