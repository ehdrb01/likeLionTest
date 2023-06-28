package com.likelion.test.demo.service;

import com.likelion.test.demo.dto.UserDto;
import com.likelion.test.demo.entity.User;
import com.likelion.test.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Transactional
    public void addUser(UserDto userDto) {
        User newUser = userRepository.save(User.toUser(userDto));
        log.info(userDto.getUserName());
    }
    @Transactional
    public User getOneUser(Long userId) {
        User newUser = userRepository.getOne(userId);
        return newUser;
    }
    @Transactional
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    @Transactional
    public void updateUserInfo(UserDto userDto) {
        User user = userRepository.getOne(userDto.getUserId());

        user.setUserName(userDto.getUserName());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setStudentId(userDto.getStudentId());
    }
    @Transactional
    public void deleteAllUser() {
        userRepository.deleteAll();
    }
}
