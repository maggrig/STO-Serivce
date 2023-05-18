package mag.grig.controller;

import mag.grig.entity.Order;
import mag.grig.entity.dto.OrderDTO;
import mag.grig.service.CarService;
import mag.grig.service.ClientService;
import mag.grig.service.OrderService;
import mag.grig.service.PostService;
import mag.grig.service.security.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final ClientService clientService;
    private final PostService postService;
    private final UserService userService;


    public OrderController(OrderService orderService,
                           CarService carService,
                           ClientService clientService,
                           PostService postService,
                           UserService userService
    ) {
        this.orderService = orderService;
        this.carService = carService;
        this.clientService = clientService;
        this.postService = postService;
        this.userService = userService;
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
        orderDTO.setClient(String.valueOf(clientId));
        orderDTO.setCar(String.valueOf(carId));
        orderDTO.setPost(String.valueOf(postId));
        orderService.saveOrder(orderDTO);
        return "redirect:/order/orders";
    }

    @GetMapping("/create")
    public String newOrderForm(Model model) {
        model.addAttribute("clientDTO", clientService.findAll());
        model.addAttribute("postDTO", postService.findAll());
        model.addAttribute("carDTO", carService.findAll());
        model.addAttribute("userDTO", userService.findAll());
        model.addAttribute("acceptor", userService.findAll());
        model.addAttribute("executor", userService.findAll());
        model.addAttribute("orderDTO", new OrderDTO());
        return "order/newOrder";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orderService.getOrderDTOs(orders));
        model.addAttribute("clientDTO", clientService.findAll());
        model.addAttribute("postDTO", postService.findAll());
        model.addAttribute("carDTO", carService.findAll());
        model.addAttribute("userDTO", userService.findAll());
        model.addAttribute("acceptor", userService.findAll());
        model.addAttribute("executor", userService.findAll());
        return "order/orders";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/orders/{orderId}")
    public String getOrderDetails(@PathVariable Long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "order/orderDetails";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/edit/{id}")
    public String editOrderForm(//@ModelAttribute("orderDTO") OrderDTO orderDTO,
                                @PathVariable("id") Long id,
                                Model model) {

        Order order = orderService.getOrderById(id);
        model.addAttribute("orderDTO", orderService.convertOrderToOrderDTO(order));
        return "order/orderEdit";
    }

    /*
    public String addOrder(@ModelAttribute("orderDTO") @Valid OrderDTO orderDTO, BindingResult bindingResult, Model model) {
     */
    @PostMapping("/edit")
    public String editOrder(@ModelAttribute("orderDTO") OrderDTO orderDTO, BindingResult result) throws ParseException {
        if (result.hasErrors()) {
            return "order/orders";
        }
        orderService.saveOrder(orderDTO);
//        return "redirect:order/orders" + orderDTO.getId();
        return "order/orders";
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
        orderService.deleteById(id);
        return "redirect:/order/orders";
    }

    @GetMapping("/items")
    public String showItems(Model model, @RequestParam(defaultValue = "id") String sortField,
                            @RequestParam(defaultValue = "asc") String sortOrder) {
        List<Order> orders = orderService.findAllSorted(sortField, sortOrder);
        model.addAttribute("items", orders);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortOrder", sortOrder);
        return "items/index";
    }

}
