package com.likelion.test.demo.service;

import com.likelion.test.demo.dto.CarDto;
import com.likelion.test.demo.entity.Car;
import com.likelion.test.demo.entity.User;
import com.likelion.test.demo.repository.CarRepository;
import com.likelion.test.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    @Transactional
    public void addCar(CarDto carDto, Long userId) {
        Car newCar = carRepository.save(Car.toCar(carDto, userRepository.getById(userId)));
    }
    @Transactional
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
    @Transactional
    public Car findOneCar(Long carId) {
        Car car = carRepository.getById(carId);

        return car;
    }
    @Transactional
    public List<Car> findAllCar() {
        List<Car> carList = carRepository.findAll();

        return carList;
    }
    @Transactional
    public void updateCar(CarDto carDto) {
        Car car = carRepository.getById(carDto.getCarId());

        car.setCarColor(carDto.getCarColor());
        car.setCarType(carDto.getCarType());
        car.setCarNumber(carDto.getCarNumber());
    }

    @Transactional
    public List<Car> findCarByUserId(Long id) {
        List<Car> carList = carRepository.findAllByUserId(id);

        return carList;
    }
}
