package com.likelion.test.demo.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CarUpdateRequest {
    private Long carId;
    private String carNumber;
    private String carType;
    private String carColor;
    private Long userId;
}
