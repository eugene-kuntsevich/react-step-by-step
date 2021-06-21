package com.app.service;

import com.app.model.Order;
import com.app.service.api.OrderService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Override
  public Order findOrderById(Long id) {
    return null;
  }

  @Override
  public List<Order> findOrdersByStatus(Long statusId) {
    return null;
  }

  @Override
  public List<Order> findAllOrders() {
    return null;
  }

  @Override
  public Long addOrder(Order order) {
    return null;
  }

  @Override
  public void updateOrder(Order order) {

  }

  @Override
  public void deleteOrder(Order order) {

  }

  @Override
  public void deleteOrderById(Long orderId) {

  }
}
