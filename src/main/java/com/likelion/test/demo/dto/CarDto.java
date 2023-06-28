package com.likelion.test.demo.dto;

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
}
