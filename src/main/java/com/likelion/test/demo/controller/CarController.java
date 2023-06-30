package com.likelion.test.demo.controller;

import com.likelion.test.demo.dto.CarDto;
import com.likelion.test.demo.entity.Car;
import com.likelion.test.demo.entity.User;
import com.likelion.test.demo.request.CarRequest;
import com.likelion.test.demo.response.CarResponse;
import com.likelion.test.demo.response.UserResponse;
import com.likelion.test.demo.service.CarService;
import com.likelion.test.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    @Autowired
    private final CarService carService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping("/add")
    public ResponseEntity<Void> addCar(@RequestBody CarRequest carRequest) {
        carService.addCar(CarDto.toAdd(carRequest), carRequest.getUserId());

        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);

        return ResponseEntity.ok(null);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CarResponse> getOneCar(@PathVariable Long id) {
        CarResponse carResponse = CarResponse.toCarResponse(carService.findOneCar(id));

        return ResponseEntity.ok(carResponse);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<CarResponse>> getAllCar() {
        List<Car> carList = carService.findAllCar();
        List<CarResponse> carResponseList = carList.stream()
                .map(CarResponse::toCarResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(carResponseList);
    }
    @PatchMapping("/update")
    public ResponseEntity<Void> updateCar(@RequestBody CarRequest carRequest) {
        carService.updateCar(CarDto.toAdd(carRequest));

        return ResponseEntity.ok(null);
    }
}
