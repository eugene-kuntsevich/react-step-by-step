package com.app.service.api;

import com.app.model.OrderStatus;
import java.util.List;

public interface OrderStatusService {

  void addOrderStatus(OrderStatus orderStatus);

  OrderStatus findOrderStatusById(Long id);

  void deleteOrderStatus(OrderStatus orderStatus);

  void deleteOrderStatusById(Long orderStatusId);

  List<OrderStatus> findAllOrderStatuses();
}
