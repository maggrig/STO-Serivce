package mag.grig.controller;

import jakarta.validation.Valid;
import mag.grig.entity.Car;
import mag.grig.entity.Client;
import mag.grig.service.CarService;
import mag.grig.service.ClientService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/client")
@Controller
public class ClientController {
    private final ClientService clientService;
    private final CarService carService;

    public ClientController(ClientService clientService, CarService carService) {
        this.clientService = clientService;
        this.carService = carService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("client", new Client());
        model.addAttribute("cars", cars);
        return "client/newClient";
    }

    @PostMapping("/create")
    public String createClient(@ModelAttribute("client") @Valid Client client,
                               @NotNull BindingResult result) {
        if (result.hasErrors()) {
            return "client/newClient";
        }
        clientService.saveClient(client);
        return "client/clients";
    }

    @GetMapping("/clients")
    public String showAllClient(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "client/clients";
    }
}
