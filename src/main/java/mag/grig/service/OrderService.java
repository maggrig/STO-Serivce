package mag.grig.service;

import mag.grig.entity.Order;
import mag.grig.entity.dto.OrderDTO;

import java.text.ParseException;
import java.util.List;
// Начало (ПРИЁМЩИК)
//Обращение заказчика, создание заказа и т.д.

public interface OrderService {
    OrderDTO convertOrderToOrderDTO(Order order);

    Order getOrderById(Long orderId);

    List<OrderDTO> getOrderDTOs(List<Order> orders);

    List<Order> getAllOrders();

    void saveOrder(Order order) throws ParseException;

    void saveOrder(OrderDTO orderDTO) throws ParseException;

    void deleteById(Long id);

    List<Order> findAllSorted(String sortField, String sortOrder);

    void merge(Order order) throws ParseException;

    Order getById(Long id);
}
