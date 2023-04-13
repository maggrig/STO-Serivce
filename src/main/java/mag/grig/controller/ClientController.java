package mag.grig.controller;

import jakarta.validation.Valid;
import mag.grig.entity.Car;
import mag.grig.entity.Client;
import mag.grig.repository.CarRepository;
import mag.grig.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final CarRepository carRepository;

    public ClientController(ClientService clientService, CarRepository carRepository) {
        this.clientService = clientService;
        this.carRepository = carRepository;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("client", new Client());
        model.addAttribute("cars", cars);
        return "client/newClient";
    }

    @PostMapping("/create")
    public String createClient(@ModelAttribute("client") @Valid Client client,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "client/newClient";
        }
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients")
    public String showAllClient(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "client/clients";
    }
}
