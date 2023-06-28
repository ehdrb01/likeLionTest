package com.likelion.test.demo.service;

import com.likelion.test.demo.dto.CarDto;
import com.likelion.test.demo.entity.Car;
import com.likelion.test.demo.entity.User;
import com.likelion.test.demo.repository.CarRepository;
import com.likelion.test.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public void addCar(CarDto carDto, Long userId) {
        Car newCar = carRepository.save(Car.toCar(carDto, userRepository.getById(userId)));
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    public Car findOneCar(Long carId) {
        Car car = carRepository.getById(carId);

        return car;
    }

    public List<Car> findAllCar() {
        List<Car> carList = carRepository.findAll();

        return carList;
    }

    public void updateCar(CarDto carDto) {
        Car car = carRepository.getById(carDto.getCarId());

        car.setCarColor(carDto.getCarColor());
        car.setCarType(carDto.getCarType());
        car.setCarNumber(carDto.getCarNumber());
    }
}
