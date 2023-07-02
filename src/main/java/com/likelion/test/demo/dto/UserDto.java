package com.likelion.test.demo.dto;

import com.likelion.test.demo.entity.Car;
import com.likelion.test.demo.entity.User;
import com.likelion.test.demo.request.UserRequest;
import com.likelion.test.demo.request.UserUpdateRequest;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long userId;

    private String studentId;

    private String userName;

    private Integer age;

    private String phoneNumber;

    private Boolean gender;

    private List<CarDto> carDtoList = new ArrayList<>();

    public static UserDto toAdd(UserRequest userRequest) {
        return UserDto.builder()
                .userName(userRequest.getUserName())
                .age(userRequest.getAge())
                .gender(userRequest.getGender())
                .phoneNumber(userRequest.getPhoneNumber())
                .studentId(userRequest.getStudentId())
                .build();
    }
    public static UserDto toUpdate(UserUpdateRequest userUpdateRequest) {
        return UserDto.builder()
                .userName(userUpdateRequest.getUserName())
                .userId(userUpdateRequest.getUserId())
                .age(userUpdateRequest.getAge())
                .gender(userUpdateRequest.getGender())
                .phoneNumber(userUpdateRequest.getPhoneNumber())
                .studentId(userUpdateRequest.getStudentId())
                .build();
    }
}
