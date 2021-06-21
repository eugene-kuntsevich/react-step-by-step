package com.app.model;

public class Order {

  private Long id;
  private OrderStatus orderStatus;
  private Car car;
  private Master master;

  public Order(Long id, OrderStatus orderStatus, Car car, Master master) {
    this.id = id;
    this.orderStatus = orderStatus;
    this.car = car;
    this.master = master;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Master getMaster() {
    return master;
  }

  public void setMaster(Master master) {
    this.master = master;
  }
}
