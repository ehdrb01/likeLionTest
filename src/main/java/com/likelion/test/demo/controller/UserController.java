package com.likelion.test.demo.controller;

import com.likelion.test.demo.dto.UserDto;
import com.likelion.test.demo.entity.User;
import com.likelion.test.demo.request.UserRequest;
import com.likelion.test.demo.response.UserResponse;
import com.likelion.test.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping("/add")
    public ResponseEntity<Void> addUser(@RequestBody UserRequest userRequest) {
        log.info(userRequest.getUserName());
        userService.addUser(UserDto.toAdd(userRequest));

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAllUser() {
        userService.deleteAllUser();

        return ResponseEntity.ok(null);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserResponse> getOneUser(@PathVariable Long userId) {
        User user = userService.getOneUser(userId);

        return ResponseEntity.ok(UserResponse.from(user));
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<UserResponse>> getAllUser() {
        List<User> userList = userService.getAllUser();
        List<UserResponse> userResponseList = userList.stream()
                .map(UserResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userResponseList);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return ResponseEntity.ok(null);
    }
    @PatchMapping("/update")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest) {
        userService.updateUserInfo(UserDto.toAdd(userRequest));
        User user = User.toUser(UserDto.toAdd(userRequest));
        UserResponse userResponse = UserResponse.from(user);

        return ResponseEntity.ok(userResponse);
    }

}
