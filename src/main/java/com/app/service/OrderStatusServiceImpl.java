package com.app.service;

import static com.app.AppStorage.orderStatusIdGenerator;
import static com.app.AppStorage.orderStatuses;
import static com.app.util.ValidatorUtil.checkNullableIdentity;
import static com.app.util.ValidatorUtil.checkNullableObject;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.OrderStatus;
import com.app.service.api.OrderStatusService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

  @Override
  public OrderStatus findOrderStatusById(Long id) throws ObjectNotExistException {
    OrderStatus orderStatus = orderStatuses.get(id);
    checkNullableObject(orderStatus);
    return orderStatus;
  }

  @Override
  public List<OrderStatus> findAllOrderStatuses() {
    return new ArrayList<>(orderStatuses.values());
  }

  @Override
  public Long addOrderStatus(OrderStatus orderStatus) {
    Long newId = ++orderStatusIdGenerator;
    orderStatus.setId(newId);
    orderStatuses.put(newId, orderStatus);
    return newId;
  }

  @Override
  public void updateOrderStatus(OrderStatus orderStatus)
      throws NullableObjectIdentityException, ObjectNotExistException {
    Long orderStatusId = orderStatus.getId();
    checkNullableIdentity(orderStatusId);
    checkNullableObject(orderStatus);
    orderStatuses.put(orderStatusId, orderStatus);
  }

  @Override
  public void deleteOrderStatusById(Long orderStatusId) throws NullableObjectIdentityException {
    checkNullableIdentity(orderStatusId);
    orderStatuses.remove(orderStatusId);
  }
}
