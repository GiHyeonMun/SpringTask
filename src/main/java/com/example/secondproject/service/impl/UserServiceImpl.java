package com.example.secondproject.service.impl;

import com.example.secondproject.dao.UserDao;
import com.example.secondproject.dto.UserDto;
import com.example.secondproject.dto.UserResponseDto;
import com.example.secondproject.entity.User;
import com.example.secondproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userDao.selectUser(id);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setId(user.getId());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User saveUser = userDao.insertUser(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());

        return userResponseDto;
    }
}
