package com.app.service.api;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.OrderStatus;
import java.util.List;

public interface OrderStatusService {

  OrderStatus findOrderStatusById(Long id) throws ObjectNotExistException;

  List<OrderStatus> findAllOrderStatuses();

  Long addOrderStatus(OrderStatus orderStatus);

  void updateOrderStatus(OrderStatus orderStatus) throws NullableObjectIdentityException, ObjectNotExistException;

  void deleteOrderStatusById(Long orderStatusId) throws NullableObjectIdentityException;
}
