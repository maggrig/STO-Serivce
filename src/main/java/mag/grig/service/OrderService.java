package mag.grig.service;

import mag.grig.dto.OrderDTO;
import mag.grig.entity.Order;

import java.text.ParseException;
import java.util.List;
// Начало (ПРИЁМЩИК)
//Обращение заказчика, создание заказа и т.д.

public interface OrderService {
    Order getOrderById(Long orderId);

    List<Order> getAllOrders();

    void saveOrder(OrderDTO order) throws ParseException;

}
