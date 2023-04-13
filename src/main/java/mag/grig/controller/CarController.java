package mag.grig.controller;

import mag.grig.entity.Car;
import mag.grig.entity.Client;
import mag.grig.repository.CarRepository;
import mag.grig.repository.ClientRepository;
import mag.grig.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/car")
@Controller
public class CarController {
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final CarService carService;

    public CarController(ClientRepository clientRepository,
                         CarRepository carRepository, CarService carService) {
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @PostMapping("/save")
    public String createOrder(/*@ModelAttribute("orderDTO") OrderDTO orderDTO,
                              @RequestParam("carDTO") Long carId,
                              @RequestParam("clientDTO") Long clientId,
                            ,*/
            BindingResult result,
            Model model) throws ParseException {

        if (result.hasErrors()) {
//            model.addAttribute("orderDTO", orderDTO);
            return "car/newCar";
        }
//        orderDTO.setClientId(clientId);
//        orderDTO.setCarId(carId);
//        orderService.saveOrder(orderDTO);
        return "redirect:/cars";
    }

    @GetMapping("/create")
    public String showNewForm(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("car", new Car());
        return "car/newCar";
    }

    @PostMapping("/delete")
    public String showDeleteForm(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("car", new Car());
        return "car/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        //    carRepository.deleteById(id);
        return "redirect:/car/cars";
    }

    @GetMapping("/cars")
    public String showAllCars(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "car/cars";
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable("id") Long id, Model model) {

        Car car = carService.findCarById(id).orElse(null);
        model.addAttribute("car", car);

        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "car/carEdit";
    }

    @PostMapping("/edit")
    public String editCar(@ModelAttribute("car") Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "car/cars";
        }

        carService.saveCar(car);

//        return "redirect:car/cars" + car.getId();
        return "car/cars";
    }

}
