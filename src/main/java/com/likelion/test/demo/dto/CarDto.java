package com.likelion.test.demo.dto;

import com.likelion.test.demo.entity.Car;
import com.likelion.test.demo.request.CarRequest;
import com.likelion.test.demo.request.CarUpdateRequest;
import com.likelion.test.demo.response.CarResponse;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private Long carId;
    private String carNumber;

    private String carType;

    private String carColor;

    public static CarDto toAdd(CarRequest carRequest) {
        return CarDto.builder()
                .carColor(carRequest.getCarColor())
                .carNumber(carRequest.getCarNumber())
                .carType(carRequest.getCarType())
                .build();
    }
    public static CarDto toUpdate(CarUpdateRequest carUpdateRequest) {
        return CarDto.builder()
                .carId(carUpdateRequest.getCarId())
                .carType(carUpdateRequest.getCarType())
                .carNumber(carUpdateRequest.getCarNumber())
                .carColor(carUpdateRequest.getCarColor())
                .build();
    }

    public static CarDto toResponse(Car car) {
        return CarDto.builder()
                .carId(car.getCarId())
                .carColor(car.getCarColor())
                .carNumber(car.getCarNumber())
                .carType(car.getCarType())
                .build();
    }

}
