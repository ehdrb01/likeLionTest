package com.likelion.test.demo.dto;

import com.likelion.test.demo.request.CarRequest;
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
                .carId(carRequest.getCarId())
                .carColor(carRequest.getCarColor())
                .carNumber(carRequest.getCarNumber())
                .carType(carRequest.getCarType())
                .build();
    }
}
