package mag.grig.controller;

import mag.grig.entity.Car;
import mag.grig.entity.Client;
import mag.grig.entity.Order;
import mag.grig.entity.Post;
import mag.grig.entity.security.User;
import mag.grig.repository.CarRepository;
import mag.grig.repository.ClientRepository;
import mag.grig.repository.PostRepository;
import mag.grig.repository.security.UserRepository;
import mag.grig.service.OrderService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Secured({"ROLE_USER"})
@RequestMapping("/orders")
@Controller
public class OrderController {

    private final OrderService orderService;
    private final PostRepository postRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public OrderController(OrderService orderService, PostRepository postRepository, ClientRepository clientRepository, CarRepository carRepository, UserRepository userRepository) {
        this.orderService = orderService;
        this.postRepository = postRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/new")
    public String newOrderForm(Model model) {

        List<Post> posts = postRepository.findAll();
        List<Car> cars = carRepository.findAll();
        List<Client> clients = clientRepository.findAll();
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("clients", clients);
        model.addAttribute("posts", posts);
        model.addAttribute("cars", cars);
        model.addAttribute("order", new Order());
        return "Orders/new";
    }

    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "Orders/orders";
    }

    @GetMapping("/orders/{orderId}")
    public String getOrderDetails(@PathVariable Long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "Orders/orderDetails";
    }
}
