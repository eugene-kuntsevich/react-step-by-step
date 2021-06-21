package com.app.service;

import com.app.model.OrderStatus;
import com.app.service.api.OrderStatusService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

  @Override
  public void addOrderStatus(OrderStatus orderStatus) {
  }

  @Override
  public OrderStatus findOrderStatusById(Long id) {
    return new OrderStatus();
  }

  @Override
  public void deleteOrderStatus(OrderStatus orderStatus) {
  }

  @Override
  public void deleteOrderStatusById(Long orderStatusId) {
  }

  @Override
  public List<OrderStatus> findAllOrderStatuses() {
    return new ArrayList<>();
  }
}
