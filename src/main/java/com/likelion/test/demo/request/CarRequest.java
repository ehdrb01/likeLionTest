package com.likelion.test.demo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CarRequest {
    private String carNumber;

    private String carType;

    private String carColor;
}
