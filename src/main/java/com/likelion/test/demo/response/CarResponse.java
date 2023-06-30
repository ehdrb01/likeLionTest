package com.likelion.test.demo.response;

import com.likelion.test.demo.entity.Car;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class CarResponse {
    private Long carId;
    private String carNumber;
    private String carType;
    private String carColor;

    public static CarResponse toCarResponse(Car car) {
        return CarResponse.builder()
                .carColor(car.getCarColor())
                .carType(car.getCarType())
                .carNumber(car.getCarNumber())
                .carId(car.getCarId())
                .build();
    }
}
