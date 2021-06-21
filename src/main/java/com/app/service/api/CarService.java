package com.app.service.api;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.Car;
import java.util.List;

public interface CarService {

  Car findCarById(Long id) throws ObjectNotExistException;

  List<Car> findAllCars();

  Car findCarByNumber(String number);

  Long addCar(Car car);

  void updateCar(Car car) throws NullableObjectIdentityException, ObjectNotExistException;

  void deleteCarById(Long carId) throws NullableObjectIdentityException;
}
