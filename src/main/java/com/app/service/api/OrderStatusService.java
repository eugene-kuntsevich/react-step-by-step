package com.app.service.api;

import com.app.model.OrderStatus;
import java.util.List;

public interface OrderStatusService {

  OrderStatus findOrderStatusById(Long id);

  List<OrderStatus> findAllOrderStatuses();

  Long addOrderStatus(OrderStatus orderStatus);

  void updateOrderStatus(OrderStatus orderStatus);

  void deleteOrderStatus(OrderStatus orderStatus);

  void deleteOrderStatusById(Long orderStatusId);
}
