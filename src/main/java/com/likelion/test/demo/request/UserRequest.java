package com.likelion.test.demo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequest {
    private String studentId;

    private String userName;

    private Integer age;

    private String phoneNumber;

    private Boolean gender;
}
