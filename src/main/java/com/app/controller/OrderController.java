package com.app.controller;

import com.app.model.Order;
import com.app.service.OrderServiceImpl;
import com.app.service.api.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

  private OrderService orderService;

  @GetMapping("/find-by-id/{id}")
  public Order findOrderById(@PathVariable Long id) {
    return orderService.findOrderById(id);
  }

  @GetMapping("/find-orders-by-status/{statusId}")
  public List<Order> findOrdersByStatus(@PathVariable Long statusId) {
    return orderService.findOrdersByStatus(statusId);
  }

  @GetMapping("/find-all-order")
  public List<Order> findAllOrder() {
    return orderService.findAllOrders();
  }

  @PostMapping("/add")
  public Long addOrder(@RequestBody Order order) {
    return orderService.addOrder(order);
  }

  @PutMapping("/update")
  public void updateOrder(@RequestBody Order order) {
    orderService.updateOrder(order);
  }

  @DeleteMapping("/delete-by-id/{id}")
  public void deleteOrderById(@PathVariable Long id) {
    orderService.deleteOrderById(id);
  }

  @Autowired
  public void setOrderStatus(OrderServiceImpl orderService) {
    this.orderService = orderService;
  }
}
