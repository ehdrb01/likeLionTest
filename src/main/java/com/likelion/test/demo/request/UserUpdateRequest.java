package com.likelion.test.demo.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor
public class UserUpdateRequest {
    private String studentId;
    private String userName;
    private Integer age;
    private String phoneNumber;
    private Boolean gender;
    private Long userId;
}
