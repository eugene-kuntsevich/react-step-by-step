package com.app.model;

public class Car {

  private Long id;
  private String carNumber;
  private Client client;
  private Order order;

  public Car() {
  }

  public Car(Long id, String carNumber, Client client) {
    this.id = id;
    this.carNumber = carNumber;
    this.client = client;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCarNumber() {
    return carNumber;
  }

  public void setCarNumber(String carNumber) {
    this.carNumber = carNumber;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}
