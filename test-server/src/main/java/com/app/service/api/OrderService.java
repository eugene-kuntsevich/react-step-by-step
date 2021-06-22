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

  Long addOrder(Order order)
      throws ObjectNotExistException, CarAlreadyAssignedToAnotherOrderException, NullableObjectIdentityException;

  void updateOrder(Order order)
      throws NullableObjectIdentityException, ObjectNotExistException, CarAlreadyAssignedToAnotherOrderException;

  void updateMasterForOrder(Long orderId, Long newMasterId) throws ObjectNotExistException, NullableObjectIdentityException;

  void updateCarForOrder(Long orderId, Long newCarId)
      throws ObjectNotExistException, NullableObjectIdentityException, CarAlreadyAssignedToAnotherOrderException;

  void unlinkMasterFromOrder(Long orderId) throws ObjectNotExistException;

  void unlinkCarFromOrder(Long orderId) throws ObjectNotExistException;

  void deleteOrderById(Long orderId) throws NullableObjectIdentityException;
}
