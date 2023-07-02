package com.likelion.test.demo.response;

import com.likelion.test.demo.dto.CarDto;
import com.likelion.test.demo.dto.UserDto;
import com.likelion.test.demo.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class UserResponse {
    private Long id;

    private String studentId;

    private String userName;

    private Integer age;

    private String phoneNumber;

    private Boolean gender;
    private List<CarDto> carDtoList = new ArrayList<>();

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .age(user.getAge())
                .gender(user.getGender())
                .userName(user.getUserName())
                .phoneNumber(user.getPhoneNumber())
                .studentId(user.getStudentId())
                .carDtoList(user.getCarList().stream().map(CarDto::toResponse).collect(Collectors.toList()))
                .build();
    }
}
