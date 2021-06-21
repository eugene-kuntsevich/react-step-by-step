package com.app.model;

public class Client {

  private Long id;
  private String firstName;
  private String secondName;
  private String phoneNumber;

  public Client(Long id, String firstName, String secondName, String phoneNumber) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.phoneNumber = phoneNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
