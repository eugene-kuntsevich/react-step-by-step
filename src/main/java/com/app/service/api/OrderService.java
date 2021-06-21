package com.app.service.api;

import com.app.model.Order;
import java.util.List;

public interface OrderService {

  Order findOrderById(Long id);

  List<Order> findOrdersByStatus(Long statusId);

  List<Order> findAllOrders();

  void saveOrder(Order order) throws Exception;

  void deleteOrder(Order order);

  void deleteOrderById(Long orderId);
}
