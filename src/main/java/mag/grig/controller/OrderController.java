package mag.grig.controller;

import mag.grig.dto.OrderDTO;
import mag.grig.entity.Client;
import mag.grig.entity.Order;
import mag.grig.repository.CarRepository;
import mag.grig.repository.ClientRepository;
import mag.grig.repository.PostRepository;
import mag.grig.repository.security.UserRepository;
import mag.grig.service.CarService;
import mag.grig.service.OrderService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

//@Secured({"ROLE_USER"})
@RequestMapping("/order")
@Controller
public class OrderController {

    private final OrderService orderService;
    private final CarService carService;
    private final PostRepository postRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final PostRepository orderRepository;

    public OrderController(OrderService orderService, CarService carService, PostRepository postRepository, ClientRepository clientRepository, CarRepository carRepository, UserRepository userRepository, PostRepository orderRepository) {
        this.orderService = orderService;
        this.carService = carService;
        this.postRepository = postRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/save")
    public String createOrder(@ModelAttribute("orderDTO") OrderDTO orderDTO,
                              @RequestParam("carDTO") Long carId,
                              @RequestParam("postDTO") Long postId,
                              @RequestParam("clientDTO") Long clientId,
                              @RequestParam("acceptor") Long acceptorId,
                              @RequestParam("executor") Long executorId,
                              BindingResult result,
                              Model model) throws ParseException {

        if (result.hasErrors()) {
            model.addAttribute("orderDTO", orderDTO);
            return "order/newOrder";
        }
        orderDTO.setAcceptorId(acceptorId);
        orderDTO.setClientId(clientId);
        orderDTO.setCarId(carId);
        orderDTO.setPostId(postId);
        orderDTO.setExecutorId(executorId);
        orderService.saveOrder(orderDTO);
        return "redirect:/order/orders";
    }

    @GetMapping("/create")
    public String newOrderForm(Model model) {
        Client client = new Client();
        List<Client> clients = clientRepository.findAll();
        client.setId(1L);
        client.setName("Hartmann");
        client.setEmail("angel.odom@example.com");
        client.setCars(carRepository.findAll());
        clients.add(0, client);
        clientRepository.save(client);
        model.addAttribute("clientDTO", clients);
        model.addAttribute("postDTO", postRepository.findAll());
        model.addAttribute("carDTO", carRepository.findAll());
        model.addAttribute("userDTO", userRepository.findAll());
        model.addAttribute("acceptor", userRepository.findAll());
        model.addAttribute("executor", userRepository.findAll());
        model.addAttribute("orderDTO", new OrderDTO());
        return "order/newOrder";
    }

    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order/orders";
    }

    @GetMapping("/orders/{orderId}")
    public String getOrderDetails(@PathVariable Long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "order/orderDetails";
    }

    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable("id") Long id, Model model) {
        Order Order = orderService.getOrderById(id);
        model.addAttribute("Order", Order);
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "order/orderEdit";
    }

    @PostMapping("/edit")
    public String editOrder(@ModelAttribute("Order") Order Order, BindingResult result) {
        if (result.hasErrors()) {
            return "order/orders";
        }
        return "redirect:order/orders" + Order.getId();
    }

    @PostMapping("/delete")
    public String showDeleteForm(@NotNull Model model) {
//        List<Client> clients = clientRepository.findAll();
//        model.addAttribute("clients", clients);
        model.addAttribute("order", new Order());
        return "order/orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderRepository.deleteById(id);
        return "redirect:/order/orders";
    }

}
