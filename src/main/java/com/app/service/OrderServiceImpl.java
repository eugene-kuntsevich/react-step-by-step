package com.app.service;

import static com.app.AppStorage.orderIdGenerator;
import static com.app.AppStorage.orderStatuses;
import static com.app.AppStorage.orders;
import static com.app.util.ValidatorUtil.checkNullableIdentity;
import static com.app.util.ValidatorUtil.checkNullableObject;

import com.app.exception.CarAlreadyAssignedToAnotherOrderException;
import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.Car;
import com.app.model.Master;
import com.app.model.Order;
import com.app.model.OrderStatus;
import com.app.service.api.CarService;
import com.app.service.api.MasterService;
import com.app.service.api.OrderService;
import com.app.service.api.OrderStatusService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private CarService carService;
  private MasterService masterService;
  private OrderStatusService orderStatusService;

  @Override
  public Order findOrderById(Long id) throws ObjectNotExistException {
    Order order = orders.get(id);
    checkNullableObject(order);
    return order;
  }

  @Override
  public List<Order> findOrdersByStatus(Long statusId) {
    return orders.values().stream().filter(order -> order.getOrderStatus().getId().equals(statusId))
        .collect(Collectors.toList());
  }

  @Override
  public List<Order> findAllOrders() {
    return new ArrayList<>(orders.values());
  }

  @Override
  public Long addOrder(Order order)
      throws ObjectNotExistException, CarAlreadyAssignedToAnotherOrderException, NullableObjectIdentityException {
    checkOrderInnerObjectsAndSetValues(order);
    checkCarAssignedToAnotherOrder(order.getCar().getId());
    Long newId = ++orderIdGenerator;
    order.setId(newId);
    if (order.getOrderStatus() == null) {
      //set initial status
      order.setOrderStatus(orderStatuses.get(1L));
    }
    orders.put(newId, order);
    return newId;
  }

  @Override
  public void updateOrder(Order order)
      throws NullableObjectIdentityException, ObjectNotExistException, CarAlreadyAssignedToAnotherOrderException {
    Long orderId = order.getId();
    checkOrderBeforeUpdate(orderId);
    checkOrderInnerObjectsAndSetValues(order);
    checkCarAssignedToAnotherOrder(order.getCar().getId());
    orders.put(orderId, order);
  }

  @Override
  public void updateMasterForOrder(Long orderId, Long newMasterId)
      throws ObjectNotExistException, NullableObjectIdentityException {
    Order orderFromStorage = checkOrderBeforeUpdate(orderId);
    Master newMaster = masterService.findMasterById(newMasterId);
    orderFromStorage.setMaster(newMaster);
    orders.put(orderId, orderFromStorage);
  }

  @Override
  public void updateCarForOrder(Long orderId, Long newCarId)
      throws ObjectNotExistException, NullableObjectIdentityException, CarAlreadyAssignedToAnotherOrderException {
    checkCarAssignedToAnotherOrder(newCarId);
    Order orderFromStorage = checkOrderBeforeUpdate(orderId);
    Car newCar = carService.findCarById(newCarId);
    orderFromStorage.setCar(newCar);
    orders.put(orderId, orderFromStorage);
  }

  @Override
  public void unlinkMasterFromOrder(Long orderId) throws ObjectNotExistException {
    Order orderFromStorage = orders.get(orderId);
    checkNullableObject(orderFromStorage);
    orderFromStorage.setMaster(null);
    orders.put(orderId, orderFromStorage);
  }

  @Override
  public void unlinkCarFromOrder(Long orderId) throws ObjectNotExistException {
    Order orderFromStorage = orders.get(orderId);
    checkNullableObject(orderFromStorage);
    orderFromStorage.setCar(null);
    orders.put(orderId, orderFromStorage);
  }

  private void checkOrderInnerObjectsAndSetValues(Order order) throws ObjectNotExistException {
    Car car = carService.findCarById(order.getCar().getId());
    Master master = masterService.findMasterById(order.getMaster().getId());
    OrderStatus orderStatus = orderStatusService
        .findOrderStatusById(order.getOrderStatus().getId());
    order.setMaster(master);
    order.setCar(car);
    order.setOrderStatus(orderStatus);
  }

  private void checkCarAssignedToAnotherOrder(Long carId)
      throws NullableObjectIdentityException, CarAlreadyAssignedToAnotherOrderException {
    checkNullableIdentity(carId);
    long count = orders.values().stream().filter(Objects::nonNull).filter(order -> {
      Car car = order.getCar();
      if (car != null) {
        return car.getId().equals(carId);
      }
      return false;
    })
        .count();
    if (count > 0) {
      throw new CarAlreadyAssignedToAnotherOrderException();
    }
  }

  private Order checkOrderBeforeUpdate(Long orderId)
      throws NullableObjectIdentityException, ObjectNotExistException {
    checkNullableIdentity(orderId);
    Order orderFromStorage = orders.get(orderId);
    checkNullableObject(orderFromStorage);
    return orderFromStorage;
  }

  @Override
  public void deleteOrderById(Long orderId) throws NullableObjectIdentityException {
    checkNullableIdentity(orderId);
    orders.remove(orderId);
  }

  @Autowired
  public void setMasterService(MasterService masterService) {
    this.masterService = masterService;
  }

  @Autowired
  public void setCarService(CarService carService) {
    this.carService = carService;
  }

  @Autowired
  public void setOrderStatusService(OrderStatusService orderStatusService) {
    this.orderStatusService = orderStatusService;
  }
}
