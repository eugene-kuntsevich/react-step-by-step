package com.app.service;

import com.app.model.OrderStatus;
import com.app.service.api.OrderStatusService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

  @Override
  public OrderStatus findOrderStatusById(Long id) {
    return null;
  }

  @Override
  public List<OrderStatus> findAllOrderStatuses() {
    return null;
  }

  @Override
  public Long addOrderStatus(OrderStatus orderStatus) {
    return null;
  }

  @Override
  public void updateOrderStatus(OrderStatus orderStatus) {

  }

  @Override
  public void deleteOrderStatus(OrderStatus orderStatus) {

  }

  @Override
  public void deleteOrderStatusById(Long orderStatusId) {

  }
}
