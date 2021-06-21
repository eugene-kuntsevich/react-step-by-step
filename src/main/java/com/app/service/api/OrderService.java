package com.app.service.api;

import com.app.exception.CarAlreadyAssignedToAnotherOrderException;
import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.Order;
import java.util.List;

public interface OrderService {

  Order findOrderById(Long id) throws ObjectNotExistException;

  List<Order> findOrdersByStatus(Long statusId);

  List<Order> findAllOrders();

  Long addOrder(Order order) throws ObjectNotExistException, CarAlreadyAssignedToAnotherOrderException, NullableObjectIdentityException;

  void updateOrder(Order order)
      throws NullableObjectIdentityException, ObjectNotExistException, CarAlreadyAssignedToAnotherOrderException;

  void deleteOrderById(Long orderId) throws NullableObjectIdentityException;

  //update Master for Order
  //update Car for Order
  //remove Master for Order
  //remove Car for Order
}
