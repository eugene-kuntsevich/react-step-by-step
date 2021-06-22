package com.app.controller;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.OrderStatus;
import com.app.service.OrderStatusServiceImpl;
import com.app.service.api.OrderStatusService;
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
@RequestMapping("/order-status")
public class OrderStatusController {

  private OrderStatusService orderStatusService;

  @GetMapping("/find-by-id/{id}")
  public OrderStatus findOrderStatusById(@PathVariable Long id) throws ObjectNotExistException {
    return orderStatusService.findOrderStatusById(id);
  }

  @GetMapping("/find-all")
  public List<OrderStatus> findAllOrderStatuses() {
    return orderStatusService.findAllOrderStatuses();
  }

  @PostMapping("/add")
  public void addOrderStatus(@RequestBody OrderStatus orderStatus) {
    orderStatusService.addOrderStatus(orderStatus);
  }

  @PutMapping("/update")
  public void updateOrderStatus(@RequestBody OrderStatus orderStatus)
      throws ObjectNotExistException, NullableObjectIdentityException {
    orderStatusService.updateOrderStatus(orderStatus);
  }

  @DeleteMapping("/delete-by-id/{id}")
  public void deleteOrderStatusById(@PathVariable Long id) throws NullableObjectIdentityException {
    orderStatusService.deleteOrderStatusById(id);
  }

  @Autowired
  public void setOrderStatus(OrderStatusServiceImpl orderStatusService) {
    this.orderStatusService = orderStatusService;
  }
}
