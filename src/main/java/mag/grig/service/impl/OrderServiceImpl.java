package mag.grig.service.impl;

import jakarta.persistence.EntityNotFoundException;
import mag.grig.entity.Order;
import mag.grig.entity.dto.OrderDTO;
import mag.grig.entity.repository.CarRepository;
import mag.grig.entity.repository.ClientRepository;
import mag.grig.entity.repository.OrderRepository;
import mag.grig.entity.repository.PostRepository;
import mag.grig.entity.repository.security.UserRepository;
import mag.grig.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Order service.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final PostRepository postRepository;

    /**
     * Instantiates a new Order service.
     *
     * @param userRepository    the user repository
     * @param orderRepository   the order repository
     * @param clientRepository1
     * @param postRepository
     */
    public OrderServiceImpl(UserRepository userRepository,
                            OrderRepository orderRepository,
                            ClientRepository clientRepository1,
                            CarRepository carRepository,
                            PostRepository postRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository1;
        this.carRepository = carRepository;
        this.postRepository = postRepository;
    }

    /**
     * @param order_new
     * @return OrderDTO
     */
    @Transactional
    @Override
    public OrderDTO convertOrderToOrderDTO(Order order_new) {
        Order order = order_new;
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
//        User acceptor=;
        orderDTO.setAcceptor(String.valueOf(userRepository.findById(order.getAcceptor()).orElse(null).getLastName()));
        orderDTO.setExecutor(String.valueOf(userRepository.findById(order.getExecutor()).orElse(null).getLastName()));
        orderDTO.setClient(String.valueOf(clientRepository.findById(order.getClient()).orElse(null).getName()));
        orderDTO.setCar(String.valueOf(carRepository.findById(order.getCar()).orElse(null).getName()));
        orderDTO.setPost(String.valueOf(postRepository.findById(order.getPost()).orElse(null).getName()));
        orderDTO.setStartDate(String.valueOf(order.getStartDate()));
        orderDTO.setEndDate(String.valueOf(order.getEndDate()));

        orderDTO.setWarning(order.isWarning());
        orderDTO.setError(order.isError());
        orderDTO.setFinished(order.isFinished());
//        orderDTO.setCar(String.valueOf(carRepository.findById(order.getCar())));
        return orderDTO;
    }

    @Override
    public Order getOrderById(Long orderId) {
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO= getOrderDTOByOrder(order);
        return orderRepository.findById(orderId).orElseThrow(() ->
                new EntityNotFoundException("Order with id " + orderId + " not found"));
    }

    /**
     * @param orders
     * @return
     */
    @Override
    public List<OrderDTO> getOrderDTOs(List<Order> orders) {
//        List<User> users = userRepository.findAll();
//        List<User> users = userRepository.findByIdOrderById(Long.valueOf("id"));
        return orders.stream().map(this::convertOrderToOrderDTO)
                .collect(Collectors.toList());
    }

    /**
     * @return AllOrders
     */
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * @param order
     * @throws ParseException
     */
    @Override
    public void saveOrder(Order order) throws ParseException {

    }

    public Order orderDTOToOrder(OrderDTO orderDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateStart = LocalDateTime.parse(orderDTO.getStartDate(), formatter);
        LocalDateTime dateEnd = LocalDateTime.parse(orderDTO.getEndDate(), formatter);
        Date date_end = Date.from(dateEnd.atZone(ZoneId.systemDefault()).toInstant());
        Date date_start = Date.from(dateStart.atZone(ZoneId.systemDefault()).toInstant());
        Order order = new Order();
        order.setStartDate(date_start);
        order.setEndDate(date_end);
        order.setClient(clientRepository.findByName(orderDTO.getClient()).getId());
        order.setCar(carRepository.findByName(orderDTO.getCar()).getId());
        order.setPost(postRepository.findByName(orderDTO.getPost()).getId());
        order.setAcceptor(userRepository.findByLastName(orderDTO.getAcceptor()).getId());
        order.setExecutor(userRepository.findByLastName(orderDTO.getExecutor()).getId());
        order.setFinished(orderDTO.isFinished());
        order.setError(orderDTO.isError());
        order.setWarning(orderDTO.isWarning());
        return order;
    }

    /**
     * @param orderDTO
     */
    @Override
    public void saveOrder(OrderDTO orderDTO) throws ParseException {
        Order order = new Order();
        order = orderDTOToOrder(orderDTO);
        merge(order);
        orderRepository.flush();
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    /**
     * @param sortField
     * @param sortOrder
     * @return
     */
    @Override
    public List<Order> findAllSorted(String sortField, String sortOrder) {
        //    Sort sort   = new Sort(Sort.by(DESC, "id"),"id");
        return orderRepository.findByOrderByIdAsc();
    }

    @Override
    public void merge(Order order) throws ParseException {
        orderRepository.save(order);
    }

    /**
     * @return
     */
    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }
}
