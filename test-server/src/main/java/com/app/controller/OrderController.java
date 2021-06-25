package com.app.controller;

import com.app.exception.CarAlreadyAssignedToAnotherOrderException;
import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.Order;
import com.app.service.OrderServiceImpl;
import com.app.service.api.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

  private OrderService orderService;

  @GetMapping("/find-by-id/{id}")
  public Order findOrderById(@PathVariable Long id) throws ObjectNotExistException {
    return orderService.findOrderById(id);
  }

  @GetMapping("/find-orders-by-status/{statusId}")
  public List<Order> findOrdersByStatus(@PathVariable Long statusId) {
    return orderService.findOrdersByStatus(statusId);
  }

  @GetMapping("/find-all")
  public List<Order> findAllOrder() {
    return orderService.findAllOrders();
  }

  @PostMapping("/add")
  public Long addOrder(@RequestBody Order order)
      throws ObjectNotExistException, CarAlreadyAssignedToAnotherOrderException, NullableObjectIdentityException {
    return orderService.addOrder(order);
  }

  @PutMapping("/update")
  public void updateOrder(@RequestBody Order order)
      throws ObjectNotExistException, NullableObjectIdentityException, CarAlreadyAssignedToAnotherOrderException {
    orderService.updateOrder(order);
  }

  @PutMapping("/update-master-for-order/{orderId}/{newMasterId}")
  public void updateMasterForOrder(@PathVariable Long orderId, @PathVariable Long newMasterId)
      throws ObjectNotExistException, NullableObjectIdentityException {
    orderService.updateMasterForOrder(orderId, newMasterId);
  }

  @PutMapping("/update-car-for-order/{orderId}/{newCarId}")
  public void updateCarForOrder(@PathVariable Long orderId, @PathVariable Long newCarId)
      throws ObjectNotExistException, NullableObjectIdentityException, CarAlreadyAssignedToAnotherOrderException {
    orderService.updateCarForOrder(orderId, newCarId);
  }

  @PutMapping("/unlink-master-from-order/{orderId}")
  public void unlinkMasterFromOrder(@PathVariable Long orderId) throws ObjectNotExistException {
    orderService.unlinkMasterFromOrder(orderId);
  }

  @PutMapping("/unlink-car-from-order/{orderId}")
  public void unlinkCarFromOrder(@PathVariable Long orderId) throws ObjectNotExistException {
    orderService.unlinkCarFromOrder(orderId);
  }

  @DeleteMapping("/delete-by-id/{id}")
  public void deleteOrderById(@PathVariable Long id) throws NullableObjectIdentityException {
    orderService.deleteOrderById(id);
  }

  @Autowired
  public void setOrderStatus(OrderServiceImpl orderService) {
    this.orderService = orderService;
  }
}
