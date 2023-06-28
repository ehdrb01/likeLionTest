package com.likelion.test.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.likelion.test.demo.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;

    private String userName;

    private Integer age;

    private String phoneNumber;

    private Boolean gender;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Car> carList = new ArrayList<>();

    public static User toUser(UserDto userDto) {
        return User.builder()
                .userName(userDto.getUserName())
                .age(userDto.getAge())
                .gender(userDto.getGender())
                .phoneNumber(userDto.getPhoneNumber())
                .studentId(userDto.getStudentId())
                .build();
    }




}
