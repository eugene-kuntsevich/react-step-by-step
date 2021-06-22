package com.app.controller;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.Car;
import com.app.service.CarServiceImpl;
import com.app.service.api.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

  private CarService carService;

  @GetMapping("/find-by-id/{id}")
  public Car findCarById(@PathVariable Long id) throws ObjectNotExistException {
    return carService.findCarById(id);
  }

  @GetMapping("/find-by-number/{number}")
  public Car findCarByNumber(@PathVariable String number) {
    return carService.findCarByNumber(number);
  }

  @GetMapping("/find-all")
  public List<Car> findAllCars() {
    return carService.findAllCars();
  }

  @PostMapping("/add")
  public Long addCar(@RequestBody Car car) {
    return carService.addCar(car);
  }

  @PutMapping("/update")
  public void updateCar(@RequestBody Car car)
      throws ObjectNotExistException, NullableObjectIdentityException {
    carService.updateCar(car);
  }

  @DeleteMapping("/delete-by-id/{id}")
  public void deleteCarById(@PathVariable Long id) throws NullableObjectIdentityException {
    carService.deleteCarById(id);
  }

  @Autowired
  public void setCarService(CarServiceImpl carService) {
    this.carService = carService;
  }
}
