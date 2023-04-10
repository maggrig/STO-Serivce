package mag.grig.service;

import mag.grig.entity.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Long orderId);

    List<Order> getAllOrders();
}
