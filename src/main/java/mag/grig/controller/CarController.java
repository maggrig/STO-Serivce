package mag.grig.controller;

import mag.grig.entity.Car;
import mag.grig.entity.Client;
import mag.grig.entity.dto.CarDTO;
import mag.grig.service.CarService;
import mag.grig.service.ClientService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/car")
@Controller
public class CarController {
    private final ClientService clientService;
    private final CarService carService;

    public CarController(ClientService clientService, CarService carService) {
        this.clientService = clientService;
        this.carService = carService;
    }

    @PostMapping("/save")
    public String createCar(@ModelAttribute("carDTO") CarDTO carDTO,
                            Model model,
                            BindingResult result
    ) throws ParseException {

        if (result.hasErrors()) {
            model.addAttribute("carDTO", carDTO);
            return "/car/newCar";
        }
//        orderDTO.setClientId(clientId);
//        orderDTO.setCarId(carId);
        carService.saveCar(carDTO);
        return "redirect:/car/cars";
    }

    @GetMapping("/create")
    public String showNewForm(@NotNull Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("car", new Car());
        return "car/newCar";
    }

    @PostMapping("/delete")
    public String showDeleteForm(@NotNull Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("car", new Car());
        return "car/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        carService.deleteById(id);
        return "redirect:/car/cars";
    }

    @GetMapping("/cars")
    public String showAllCars(@NotNull Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "car/cars";
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable("id") Long id, @NotNull Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "car/carEdit";
    }

    @PostMapping("/edit")
    public String editCar(@ModelAttribute("car") CarDTO car, @NotNull BindingResult result) {
        if (result.hasErrors()) {
            return "car/cars";
        }
        carService.saveCar(car);
//        return "redirect:/edit/{id}" + car.getId();
        return "car/cars";
    }

}
