package mag.grig.service.impl;

import mag.grig.dto.OrderDTO;
import mag.grig.entity.Order;
import mag.grig.repository.CarRepository;
import mag.grig.repository.ClientRepository;
import mag.grig.repository.OrderRepository;
import mag.grig.repository.PostRepository;
import mag.grig.repository.security.UserRepository;
import mag.grig.service.OrderService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * The type Order service.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CarRepository carRepository;
    private final PostRepository postRepository;
    private final ClientRepository clientRepository;


    /**
     * Instantiates a new Order service.
     *
     * @param userRepository   the user repository
     * @param orderRepository  the order repository
     * @param carRepository    the car repository
     * @param postRepository   the post repository
     * @param clientRepository the client repository
     */
    public OrderServiceImpl(UserRepository userRepository, OrderRepository orderRepository,
                            CarRepository carRepository, PostRepository postRepository,
                            ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
        this.postRepository = postRepository;
        this.clientRepository = clientRepository;
    }

    /**
     * @param orderId
     * @return Order
     */
    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.getReferenceById(orderId);
    }

    /**
     * @return AllOrders
     */
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * @param orderDTO
     */
    @Override
    public void saveOrder(OrderDTO orderDTO) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateStart = LocalDateTime.parse(orderDTO.getStartDate(), formatter);
        LocalDateTime dateEnd = LocalDateTime.parse(orderDTO.getEndDate(), formatter);
        Date date_end = Date.from(dateEnd.atZone(ZoneId.systemDefault()).toInstant());
        Date date_start = Date.from(dateStart.atZone(ZoneId.systemDefault()).toInstant());
//        Date dateEnd = (Date) formatter.parse(orderDTO.getEndDate());
        Order order = new Order();
        order.setStartDate(date_start);
        order.setEndDate(date_end);
        order.setClient(clientRepository.findById(orderDTO.getClientId()).orElse(null));
        order.setCar(carRepository.findById(orderDTO.getCarId()).orElse(null));
        order.setPost(postRepository.findById(orderDTO.getPostId()).orElse(null));
        order.setAcceptor(userRepository.findById(orderDTO.getAcceptorId()).orElse(null));
        order.setExecutor(userRepository.findById(orderDTO.getExecutorId()).orElse(null));
        order.setFinished(orderDTO.isFinished());
        order.setError(orderDTO.isError());
        order.setFinished(orderDTO.isFinished());
        orderRepository.save(order);
    }
}
