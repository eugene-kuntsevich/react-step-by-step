package com.app.converter;

import com.app.model.Car;
import com.app.model.Master;
import com.app.model.Order;
import java.util.List;
import java.util.stream.Collectors;

public class CarConverter {

  public static List<Car> convertCarsFromStorage(List<Car> cars) {
    return cars.stream().map(CarConverter::convertCarFromStorage).collect(Collectors.toList());
  }

  public static Car convertCarFromStorage(Car car) {
    var convertedCar = new Car();
    convertedCar.setId(car.getId());
    convertedCar.setCarNumber(car.getCarNumber());
    convertedCar.setClient(car.getClient());
    convertedCar.setOrder(convertOrder(car.getOrder()));
    return convertedCar;
  }

  private static Order convertOrder(Order order) {
    var convertedOrder = new Order();
    convertedOrder.setId(order.getId());
    convertedOrder.setOrderStatus(order.getOrderStatus());
    convertedOrder.setMaster(convertMaster(order.getMaster()));
    return convertedOrder;
  }

  private static Master convertMaster(Master master) {
    var convertedMaster = new Master();
    convertedMaster.setId(master.getId());
    convertedMaster.setFirstName(master.getFirstName());
    convertedMaster.setSecondName(master.getSecondName());
    return convertedMaster;
  }
}
