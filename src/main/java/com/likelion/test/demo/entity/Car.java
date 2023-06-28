package com.likelion.test.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.likelion.test.demo.dto.CarDto;
import com.likelion.test.demo.dto.UserDto;
import com.likelion.test.demo.repository.UserRepository;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String carNumber;

    private String carType;

    private String carColor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id")
    private User user; // foreign key 역할


    public static Car toCar(CarDto carDto, User user) {
        return Car.builder()
                .carNumber(carDto.getCarNumber())
                .carType(carDto.getCarType())
                .carColor(carDto.getCarColor())
                .user(user)
                .build();
    }
}
