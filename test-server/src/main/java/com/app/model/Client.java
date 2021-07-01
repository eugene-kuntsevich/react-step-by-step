package com.app.model;

public class Client {

  private String firstName;
  private String secondName;
  private String phoneNumber;

  public Client() {
  }

  public Client(String firstName, String secondName, String phoneNumber) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.phoneNumber = phoneNumber;
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
