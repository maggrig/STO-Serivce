package mag.grig.service.impl;

import mag.grig.entity.Order;
import mag.grig.repository.OrderRepository;
import mag.grig.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
}
